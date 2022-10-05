package spring5.testdemo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
import spring5.config.SpringConfig;
import spring5.service.UserService;

//在注解里面value属性值可以省略不写
//默认值是类名称，首字母小写

public class Demo01 {
    @Test
    public void testService1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();

    }
    @Test
    public void testService2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();

    }

}
