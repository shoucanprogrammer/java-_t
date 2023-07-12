package com.tl.dianping.service.impl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.dianping.dto.Result;
import com.tl.dianping.entity.Blog;
import com.tl.dianping.entity.Shop;
import com.tl.dianping.mapper.ShopMapper;
import com.tl.dianping.service.IShopService;
import com.tl.dianping.utils.CacheClient;
import com.tl.dianping.utils.RedisData;
import com.tl.dianping.utils.SystemConstants;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.tl.dianping.utils.RedisConstants.*;
import static com.tl.dianping.utils.RedisConstants.*;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    private static final ExecutorService CACHE_REBUTLD_EXECUTOR = Executors.newFixedThreadPool(10);


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CacheClient cacheClient;

    @Override
    public Result queryById(Long id) {

        // 解决缓存穿透
//       Shop shop = queryWithPassThrough(id);
       //互斥锁解决缓存击穿

        // 互斥锁解决缓存击穿
//        Shop shop = queryWithMutex(id);
        // Shop shop = cacheClient
//                 .queryWithMutex(CACHE_SHOP_KEY, id, Shop.class, this::getById, CACHE_SHOP_TTL, TimeUnit.MINUTES);

        // 逻辑过期解决缓存击穿
        Shop shop = queryWithLogicalExpire(id);
        // Shop shop = cacheClient
        //         .queryWithLogicalExpire(CACHE_SHOP_KEY, id, Shop.class, this::getById, 20L, TimeUnit.SECONDS);
//
//        if (shop == null) {
//            return Result.fail("店铺不存在！");
//        }
//        // 7.返回
        if (shop == null){
            Result.fail("店铺不存在");
        }
        return Result.ok(shop);
    }

    @Override
    @Transactional
    public Result update(Shop shop) {
        Long id = shop.getId();
        if (id == null) {
            return Result.fail("店铺id不能为空");
        }
        // 1.更新数据库
        updateById(shop);
        // 2.删除缓存
        stringRedisTemplate.delete(CACHE_SHOP_KEY + id);
        return Result.ok();
    }

    @Override
    public Result queryShopByType(Integer typeId, Integer current, Double x, Double y) {
        //1 判断是否需要根据坐标查询
        if (x == null || y == null){
            Page<Shop> page = query().eq("type_id",typeId)
                    .page(new Page<>(current,SystemConstants.DEFAULT_PAGE_SIZE));
        return Result.ok(page);
        }
        //2 计算分页参数
        int from = (current - 1) * SystemConstants.DEFAULT_PAGE_SIZE;
        int end = current * SystemConstants.DEFAULT_PAGE_SIZE;
        //3 查询redis，按照距离排序，分页，结果，shopId，distance
        String key = SHOP_GEO_KEY + typeId;
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = stringRedisTemplate.opsForGeo()
                .search(key, GeoReference.fromCoordinate(x, y), new Distance(5000),
                        RedisGeoCommands.GeoSearchCommandArgs.newGeoSearchArgs()
                                .includeDistance().limit(end));

        //4 解析id
        if (results == null){
            return Result.ok(Collections.emptyList());
        }
        //截取from-end
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> list = results.getContent();
        List<Long> ids = new ArrayList<>(list.size());
        if (list.size() <= from){
            return Result.ok(Collections.emptyList());
        }
        Map<String,Distance> distanceMap = new HashMap<>(list.size());
        list.stream().skip(from).forEach(result ->{
            //获取店铺id
            String shopIdStr = result.getContent().getName();
            ids.add(Long.valueOf(shopIdStr));
            Distance distance = result.getDistance();
            distanceMap.put(shopIdStr,distance);
        });
        //5 根据id查询Shop
        String idStr = StrUtil.join(",",ids);
        List<Shop> shops = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();
        for (Shop shop : shops){
            shop.setDistance(distanceMap.get(shop.getId().toString()).getValue());
        }
        //返回
        return Result.ok(shops);
    }

    public Shop queryWithPassThrough(Long id){
        //从redis查询店铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(CACHE_SHOP_KEY + id);
        //判断是否存在
        if (StrUtil.isNotBlank(shopJson)){
            //存在，则返回
            Shop shop = JSONUtil.toBean(shopJson, Shop.class);
            return shop;
        }
        //判断是否为空，为n空不查询数据库
        if (shopJson != null){
            return null;
        }
        //不存在，根据id查询数据库
        Shop shop = baseMapper.selectById(id);
        //不存在，返回错误
        if (shop == null){
            //将null写入redis避免缓存穿透+
            stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + id,"", CACHE_NULL_TTL,TimeUnit.MINUTES);
            return null;
        }
        stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + id,JSONUtil.toJsonStr(shop),CACHE_SHOP_TTL,TimeUnit.MINUTES);
        //存在，写入redis
        //返回
        return shop;
    }
    public Shop queryWithMutex(Long id){
        //从redis查询店铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(CACHE_SHOP_KEY + id);
        //判断是否存在
        if (StrUtil.isNotBlank(shopJson)){
            //存在，则返回
            Shop shop = JSONUtil.toBean(shopJson, Shop.class);
            return shop;
        }
        //判断是否为空，为n空不查询数据库
        if (shopJson != null){
            return null;
        }
        //实现缓存重建
        //获取互斥锁
        String lockKey = "lock:shop:" + id;
        Shop shop = null;
        try {
            boolean flag = tryLock(lockKey);
            //判断是否获取成功
            //失败，则休眠重试
            if (flag == false){
                Thread.sleep(50);
                queryWithMutex(id);
            }
            //获取成功，根据id查询数据库
            shop = baseMapper.selectById(id);
            //模拟重建延迟
            Thread.sleep(200);
            //不存在，返回错误
            if (shop == null){
                //将null写入redis避免缓存穿透+
                stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + id,"", CACHE_NULL_TTL,TimeUnit.MINUTES);
                return null;
            }
            //存在，写入redis
            stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + id,JSONUtil.toJsonStr(shop),CACHE_SHOP_TTL,TimeUnit.MINUTES);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //释放控制锁
            unlock(lockKey);
        }

        //返回
        return shop;
    }

    public Shop queryWithLogicalExpire(Long id){
        //从redis查询店铺缓存
        String shopJson = stringRedisTemplate.opsForValue().get(CACHE_SHOP_KEY + id);
        //判断是否存在
        if (StrUtil.isBlank(shopJson)){
            //未命中
            return null;
        }
       //命中，需要先把json返序列化为对象.
        RedisData redisData = JSONUtil.toBean(shopJson, RedisData.class);
        // 判断是否过期
        JSONObject data = (JSONObject) redisData.getData();
        Shop shop = JSONUtil.toBean(data, Shop.class);
        LocalDateTime expireTime = redisData.getExpireTime();
        //未过期
        if (expireTime.isAfter(LocalDateTime.now())){
            //返回店铺信息
            return shop;
        }
        //过期
        //缓存重建
        //获取互斥锁
        boolean isLock = tryLock(LOCK_SHOP_KEY + id);
        //获取成功，开启新线程，实现缓存重建
        if (isLock){
            CACHE_REBUTLD_EXECUTOR.submit(()->{
                try {
                    this.saveShop2Redis(id,20L);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    unlock(LOCK_SHOP_KEY + id);
                }
            });
        }
        //不成功，直接返回过期商品信息
        return shop;
    }

    private boolean tryLock(String key){
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 10, TimeUnit.MINUTES);
        return BooleanUtil.isTrue(flag);
    }
    private void unlock(String key){
        stringRedisTemplate.delete(key);
    }

    public void saveShop2Redis(Long id,Long expireSeconds) throws InterruptedException {
        //查询店铺数据
        Shop shop = getById(id);
        Thread.sleep(200);
        //封装逻辑时间
        RedisData redisData = new RedisData();
        redisData.setData(shop);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(expireSeconds));
        //写入Redis
        stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY+id,JSONUtil.toJsonStr(redisData));
    }


}
