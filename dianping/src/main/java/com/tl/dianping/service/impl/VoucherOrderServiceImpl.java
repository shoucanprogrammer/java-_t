package com.tl.dianping.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.SeckillVoucher;
import com.tl.dianping.entity.VoucherOrder;
import com.tl.dianping.mapper.VoucherOrderMapper;
import com.tl.dianping.service.ISeckillVoucherService;
import com.tl.dianping.service.IVoucherOrderService;
import com.tl.dianping.utils.RedisIdWorker;
import com.tl.dianping.utils.SimpleRedisLock;
import com.tl.dianping.utils.UserHolder;
import javafx.scene.layout.BorderImage;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.aop.framework.AopContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Slf4j
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {

    @Resource
    private ISeckillVoucherService seckillVoucherService;
    IVoucherOrderService proxy ;
    @Resource
    private RedisIdWorker redisIdWorker;
    @Resource
    private RedissonClient redissonClient;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private static final DefaultRedisScript<Long> SECKILL_SCRIPT;

    static {
        SECKILL_SCRIPT = new DefaultRedisScript<>();
        SECKILL_SCRIPT.setLocation(new ClassPathResource("seckill.lua"));
        SECKILL_SCRIPT.setResultType(Long.class);
    }

    private BlockingQueue<VoucherOrder> ordersTask = new ArrayBlockingQueue<>(1024*1024);
    private static final ExecutorService SECKILL_ORDER_EXECUTOR = Executors.newSingleThreadExecutor();

    @PostConstruct
    private void init() {
        SECKILL_ORDER_EXECUTOR.submit(new VoucherOrderHandler());
    }

    private class VoucherOrderHandler implements Runnable {
        String queueName = "stream.orders";
        //消息队列逻辑
        @Override
        public void run() {
            while (true) {
                try {
                    //1获取消息队列中的订单信息 XREADGROUP GROUP g1 c1 COUNT 1 BLOCK 2000 stream.order >
                    List<MapRecord<String, Object, Object>> list = stringRedisTemplate.opsForStream().read(
                            Consumer.from("g1", "c1"),
                            StreamReadOptions.empty().count(1).block(Duration.ofSeconds(2)),
                            StreamOffset.create(queueName, ReadOffset.lastConsumed())
                    );
                    //2判断消息获取是否成功
                    if (list == null || list.isEmpty()){
                        //2.1 如果获取失败，说明没有消息，继续下一次循环
                        continue;
                    }
                    //3 如果获取成功可以下单
                    MapRecord<String, Object, Object> record = list.get(0);
                    Map<Object, Object> values = record.getValue();
                    VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(values,new VoucherOrder(),true);
                    //4如获取成功，可以下单
                    handleVouncherOrder(voucherOrder);
                    //5 ACK确认 SACK stream.order g1 id
                    stringRedisTemplate.opsForStream().acknowledge(queueName,"g1",record.getId());
                } catch (Exception e) {
                    log.error("处理订单异常", e);
                    handlePendingList();
                }
            }
        }
        //阻塞队列逻辑
//        @Override
//        public void run() {
//            while (true) {
//                try {
//                  //1获取队列中的订单信息
//                    VoucherOrder voucherOrder = ordersTask.take();
//                    handleVouncherOrder(voucherOrder);
//                } catch (Exception e) {
//                    log.error("处理订单异常", e);
//                    handlePendingList();
//                }
//            }
//        }

        private void handlePendingList() {
            while (true) {
                try {
                    // 1.获取pending-list中的订单信息 XREADGROUP GROUP g1 c1 COUNT 1 BLOCK 2000 STREAMS s1 0
                    List<MapRecord<String, Object, Object>> list = stringRedisTemplate.opsForStream().read(
                            Consumer.from("g1", "c1"),
                            StreamReadOptions.empty().count(1),
                            StreamOffset.create("stream.orders", ReadOffset.from("0"))
                    );
                    // 2.判断订单信息是否为空
                    if (list == null || list.isEmpty()) {
                        // 如果为null，说明没有异常消息，结束循环
                        break;
                    }
                    // 解析数据
                    MapRecord<String, Object, Object> record = list.get(0);
                    Map<Object, Object> value = record.getValue();
                    VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(value, new VoucherOrder(), true);
                    // 3.创建订单
                    createVoucherOrder(voucherOrder);
                    // 4.确认消息 XACK
                    stringRedisTemplate.opsForStream().acknowledge("s1", "g1", record.getId());
                } catch (Exception e) {
                    log.error("处理订单异常", e);
                }
            }
        }
    }

    private void handleVouncherOrder(VoucherOrder voucherOrder) {
        //1获取用户
        Long userId = voucherOrder.getUserId();
        //2创建锁对象
        RLock lock = redissonClient.getLock("lock:order:" +userId);
        //3获取锁
        boolean isLock = lock.tryLock();
        //4判断失败，返回错误或重试
        if (!isLock){
            log.error("不允许重复下单");
            return;
        }
        try {
            proxy.createVoucherOrder(voucherOrder);
        } finally {
            lock.unlock();
        }

    }
    @Transactional
    public void createVoucherOrder(VoucherOrder voucherOrder){
        //一个一单
        Long userId = voucherOrder.getUserId();
        synchronized (
                userId.toString().intern()
        ) {

            int count = query().eq("user_id", userId).eq("voucher_id", voucherOrder.getVoucherId()).count();
            // 判断是否存在
            if (count > 0) {
                log.error("用户已经购买了一次!");
                return;
            }
            //创建订单

            //扣库存
            boolean success = seckillVoucherService.update().
                    setSql("stock = stock-1").//set stock = stock -1
                            eq("voucher_id", voucherOrder.getVoucherId()).gt("stock", 0) //where voucher_id = ? and stock = ?
                    .update();
            System.out.println(success);
            if (!success) {
                log.error("库存不足");
                return;
            }
            //6.1订单i
            save(voucherOrder);
            return ;
        }
    }

    //事务和锁冲突
//        @Transactional
//    private void createVoucherOrder(VoucherOrder voucherOrder) {
//        Long userId = voucherOrder.getUserId();
//        Long voucherId = voucherOrder.getVoucherId();
//        // 创建锁对象
//        RLock redisLock = redissonClient.getLock("lock:order:" + userId);
//        // 尝试获取锁
//        boolean isLock = redisLock.tryLock();
//        // 判断
//        if (!isLock) {
//            // 获取锁失败，直接返回失败或者重试
//            log.error("不允许重复下单！");
//            return;
//        }
//
//        try {
//            // 5.1.查询订单
//            int count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
//            // 5.2.判断是否存在
//            if (count > 0) {
//                // 用户已经购买过了
//                log.error("不允许重复下单！");
//                return;
//            }
//
//            // 6.扣减库存
//            boolean success = seckillVoucherService.update()
//                    .setSql("stock = stock - 1") // set stock = stock - 1
//                    .eq("voucher_id", voucherId).gt("stock", 0) // where id = ? and stock > 0
//                    .update();
//            if (!success) {
//                // 扣减失败
//                log.error("库存不足！");
//                return;
//            }
//
//            // 7.创建订单
//            save(voucherOrder);
//        } finally {
//            // 释放锁
//            redisLock.unlock();
//        }
//    }
//    public Result seckillVoucher(Long voucherId) {
//        //获取用户id
//        Long userId = UserHolder.getUser().getId();
//        // 1.执行lua脚本
//        Long result = stringRedisTemplate.execute(SECKILL_SCRIPT,Collections.emptyList(),
//                voucherId.toString(),userId.toString());
//        //2判断结果是否为0；
//        int r = result.intValue();
//        if (r != 0){
//            //2.1 不为0，代表没有购买资格
//            return Result.fail(r == 1 ? "库存不足":"不能重复下单");
//        }
//        //2.2 为0，有购买资格，把下单信息保存到阻塞队列
//        long orderId = redisIdWorker.nextId("order");
//        //TODO保存阻塞队列
//
//        //3.返回订单id
//        return Result.ok(0);
//
//    }

//    public Result seckillVoucher(Long voucherId) {
//        // 1.查询优惠券
//        SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
//        // 2.判断秒杀是否开始
//        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
//            // 尚未开始
//            return Result.fail("秒杀尚未开始！");
//        }
//        // 3.判断秒杀是否已经结束
//        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
//            // 尚未开始
//            return Result.fail("秒杀已经结束！");
//        }
//        // 4.判断库存是否充足
//        if (voucher.getStock() < 1) {
//            // 库存不足
//            return Result.fail("库存不足！");
//        }
//        Long userId = UserHolder.getUser().getId();
//
//        //返回订单号
////        synchronized (userId.toString().intern()){//单体架构2
//
//
//        //集群架构用redis加分布式锁
//        SimpleRedisLock simpleRedisLock = new SimpleRedisLock("order:" + userId, stringRedisTemplate);
//        //获取代理对象(事务)
//        boolean isLock = simpleRedisLock.tryLock(1200);
//        if (!isLock){
//          return Result.fail("不允许重复下单");
//        }
//        try {
//            IVoucherOrderService proxy = (IVoucherOrderService) AopContext.currentProxy();
//            Result result = proxy.createVoucherOrder(voucherId);
//            System.out.println(result.getSuccess());
//            return result;
//        } finally {
//            simpleRedisLock.unlock();
//        }
//
////        }
//    }


    @Transactional
    public Result createVoucherOrder(Long voucherId){
        //一个一单
        Long userId = UserHolder.getUser().getId();
        synchronized (userId.toString().intern()) {

            int count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
            // 判断是否存在
            if (count > 0) {
                return Result.fail("用户已经购买过了");
            }
            //创建订单
            VoucherOrder voucherOrder = new VoucherOrder();
            //扣库存
            boolean success = seckillVoucherService.update().
                    setSql("stock = stock-1").//set stock = stock -1
                            eq("voucher_id", voucherId).gt("stock", 0) //where voucher_id = ? and stock = ?
                    .update();
            System.out.println(success);
            if (!success) {
                return Result.fail("库存不足");
            }
            //6.1订单
            long orderId = redisIdWorker.nextId("order");
            voucherOrder.setId(orderId);
            //6.2用户id
            userId = UserHolder.getUser().getId();
            voucherOrder.setUserId(userId);
            //6.3代金券id
            voucherOrder.setVoucherId(voucherId);
            save(voucherOrder);
            return Result.ok(orderId);
        }
    }



//    @Transactional
//    public Result seckillVoucher(Long voucherId) {
//        // 1.查询优惠券
//        SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
//        // 2.判断秒杀是否开始
//        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
//            // 尚未开始
//            return Result.fail("秒杀尚未开始！");
//        }
//        // 3.判断秒杀是否已经结束
//        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
//            // 尚未开始
//            return Result.fail("秒杀已经结束！");
//        }
//        // 4.判断库存是否充足
//        if (voucher.getStock() < 1) {
//            // 库存不足
//            return Result.fail("库存不足！");
//        }
//        Long userId = UserHolder.getUser().getId();
//
//        synchronized (userId.toString().intern()) {
//
//            int count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
//            // 判断是否存在
//            if (count > 0) {
//                return Result.fail("用户已经购买过了");
//            }
//            //创建订单
//            VoucherOrder voucherOrder = new VoucherOrder();
//            //扣库存
//            boolean success = seckillVoucherService.update().
//                    setSql("stock = stock-1").//set stock = stock -1
//                            eq("voucher_id", voucherId).gt("stock", 0) //where voucher_id = ? and stock = ?
//                    .update();
//            System.out.println(success);
//            if (!success) {
//                return Result.fail("库存不足");
//            }
//            //6.1订单i
//            long orderId = redisIdWorker.nextId("order");
//            voucherOrder.setId(orderId);
//            //6.2用户id
//            userId = UserHolder.getUser().getId();
//            voucherOrder.setUserId(userId);
//            //6.3代金券id
//            voucherOrder.setVoucherId(voucherId);
//            save(voucherOrder);
//            return Result.ok(orderId);
//        }
//    }

//redsStream消费者组
@Override
public Result seckillVoucher(Long voucherId) {
    Long userId = UserHolder.getUser().getId();
    long orderId = redisIdWorker.nextId("order");
    // 1.执行lua脚本
    Long result = stringRedisTemplate.execute(
            SECKILL_SCRIPT,
            Collections.emptyList(),
            voucherId.toString(), userId.toString(), String.valueOf(orderId)
    );
    int r = result.intValue();
    // 2.判断结果是否为0
    if (r != 0) {
        // 2.1.不为0 ，代表没有购买资格
        return Result.fail(r == 1 ? "库存不足" : "不能重复下单");
    }
    //获取代理对象
    proxy = (IVoucherOrderService) AopContext.currentProxy();
    return Result.ok(orderId);
}


//    //放入阻塞队列
//    @Override
//    public Result seckillVoucher(Long voucherId) {
//        Long userId = UserHolder.getUser().getId();
//        long orderId = redisIdWorker.nextId("order");
//        // 1.执行lua脚本
//        Long result = stringRedisTemplate.execute(
//                SECKILL_SCRIPT,
//                Collections.emptyList(),
//                voucherId.toString(), userId.toString(), String.valueOf(orderId)
//        );
//        int r = result.intValue();
//        // 2.判断结果是否为0
//        if (r != 0) {
//            // 2.1.不为0 ，代表没有购买资格
//            return Result.fail(r == 1 ? "库存不足" : "不能重复下单");
//        }
//        // 生成订单
//        VoucherOrder voucherOrder = new VoucherOrder();
//
//        voucherOrder.setId(orderId);
//        voucherOrder.setVoucherId(voucherId);
//        voucherOrder.setUserId(userId);
//        //订单信息放入阻塞队列
//        ordersTask.add(voucherOrder);
//        proxy = (IVoucherOrderService) AopContext.currentProxy();
//        return Result.ok(orderId);
//    }



//
//    @Transactional
//    public Result createVoucherOrder(Long voucherId) {
//        // 5.一人一单
//        Long userId = UserHolder.getUser().getId();
//
//        // 创建锁对象
//        RLock redisLock = redissonClient.getLock("lock:order:" + userId);
//        // 尝试获取锁
//        boolean isLock = redisLock.tryLock();
//        // 判断
//        if (!isLock) {
//            // 获取锁失败，直接返回失败或者重试
//            return Result.fail("不允许重复下单！");
//        }
//
//        try {
//            // 5.1.查询订单
//            int count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
//            // 5.2.判断是否存在
//            if (count > 0) {
//                // 用户已经购买过了
//                return Result.fail("用户已经购买过一次！");
//            }
//
//            // 6.扣减库存
//            boolean success = seckillVoucherService.update()
//                    .setSql("stock = stock - 1") // set stock = stock - 1
//                    .eq("voucher_id", voucherId).gt("stock", 0) // where id = ? and stock > 0
//                    .update();
//            if (!success) {
//                // 扣减失败
//                return Result.fail("库存不足！");
//            }
//
//            // 7.创建订单
//            VoucherOrder voucherOrder = new VoucherOrder();
//            // 7.1.订单id
//            long orderId = redisIdWorker.nextId("order");
//            voucherOrder.setId(orderId);
//            // 7.2.用户id
//            voucherOrder.setUserId(userId);
//            // 7.3.代金券id
//            voucherOrder.setVoucherId(voucherId);
//            save(voucherOrder);
//
//            // 7.返回订单id
//            return Result.ok(orderId);
//        } finally {
//            // 释放锁
//            redisLock.unlock();
//        }
//
//    }

}
