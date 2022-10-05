package testdemo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import spring5.bean.Emp;
import spring5.service.UserService;

public class TestBean {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        //2获取配置创建对象
        UserService userService =context.getBean("userService",UserService.class);
        userService.add();
        userService.dao();

    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        //2获取配置创建对象
        Emp emp =context.getBean("emp", Emp.class);
        emp.add();

    }
}
