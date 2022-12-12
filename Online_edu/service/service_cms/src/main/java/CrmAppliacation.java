import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.educms.mapper")
@EnableCaching
@ComponentScan(basePackages = {"com.atguigu"})
public class CrmAppliacation {
    public static void main(String[] args) {
        SpringApplication.run(CrmAppliacation.class,args);
    }
}
