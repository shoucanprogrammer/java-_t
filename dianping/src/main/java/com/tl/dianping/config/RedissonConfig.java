package com.tl.dianping.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedissonConfig {
    @Configuration
    public class RedisConfig {
        @Autowired
        private RedisTemplate redisTemplate;

        @Bean
        public RedisTemplate redisTemplateInit() {
            //设置序列化Key的实例化对象
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            //设置序列化Value的实例化对象
            redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
            return redisTemplate;
        }
    }



    @Bean
    public RedissonClient redissonClient(){
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }
//    @Bean
//    public RedissonClient redissonClient2(){
//        // 配置
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6380");
//        // 创建RedissonClient对象
//        return Redisson.create(config);
//    }
//    @Bean
//    public RedissonClient redissonClient3(){
//        // 配置
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6381");
//        // 创建RedissonClient对象
//        return Redisson.create(config);
//    }
}
