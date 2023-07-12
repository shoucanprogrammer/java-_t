package com;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;


@SpringBootApplication()
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer clientConfigurationBuilderCustomizer(){
        return new LettuceClientConfigurationBuilderCustomizer() {
            @Override
            public void customize(LettuceClientConfiguration.LettuceClientConfigurationBuilder clientConfigurationBuilder) {
                clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
            }
        };
    }
}
