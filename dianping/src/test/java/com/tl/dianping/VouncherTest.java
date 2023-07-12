package com.tl.dianping;

import com.tl.dianping.entity.SeckillVoucher;
import com.tl.dianping.service.IVoucherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

import static com.tl.dianping.utils.RedisConstants.SECKILL_STOCK_KEY;

@Slf4j
@SpringBootTest
public class VouncherTest {

    @Resource
    private IVoucherService vouncherService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void RedisVounner(){
        // 保存秒杀库存到Redis中
        int id = 15;
        int stock = 100;
        stringRedisTemplate.opsForValue().set(SECKILL_STOCK_KEY + 15, String.valueOf(stock));
    }


}
