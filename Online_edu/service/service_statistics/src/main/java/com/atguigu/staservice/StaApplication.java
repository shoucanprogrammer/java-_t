package com.atguigu.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.websocket.ClientEndpoint;

@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
@MapperScan("com.atguigu.staservice.mapper")
public class StaApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaApplication.class,args);
    }
}
