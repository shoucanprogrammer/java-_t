package com.tl.dianping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@MapperScan("com.tl.dianping.mapper")
@MapperScan("com.tl.dianping.utils")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableSwagger2
@SpringBootApplication
public class DianpingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DianpingApplication.class, args);
    }

}
