import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages = {"com.atguigu"})
@SpringBootApplication
@MapperScan("com.atguigu.educenter.mapper")
@EnableDiscoveryClient //nacos注册
public class UcenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class,args);
    }
}
