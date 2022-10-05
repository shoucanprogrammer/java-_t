package spring5.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.testng.annotations.Test;
import spring5.config.TxConfig;
import spring5.service.UserService;

import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class test {

    @Test
    public void testJdbcTemplate1(){

        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testGenericApplicationContext(){
        //创建genericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //调用个cintext的方法对象注册
        context.refresh();
        context.registerBean("user1",User.class,()->new User());
        //获取在spring注册的对象
        User user = (User) context.getBean("user1");
        System.out.println(user);

    }


}
