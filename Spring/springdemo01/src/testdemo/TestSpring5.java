package testdemo;




import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import spring5.Book;

public class TestSpring5 {
    @Test
    public void testOrder(){
        //1 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2 获取配置创建的对象
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.toString();
    }
}
