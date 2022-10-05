package spring5.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import spring5.entity.Book;
import spring5.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class test {
    @Test
    public void testJdncTemplate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService",BookService.class);
//        bookService.addBook(new Book(1,"java","a"));
//        Book one = bookService.findOne(1);
//        System.out.println(one);

//        //批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"3","java","a"};
//        Object[] o2 = {"4","c++","b"};
//        Object[] o3 = {"5","MySQL","c"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchAdd(batchArgs);


//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"java1","a","3"};
//        Object[] o2 = {"c++1","b","4"};
//        Object[] o3 = {"MySQL1","c","5"};
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
//        bookService.batchUpdate(batchArgs);



        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {1};
        Object[] o2 = {3};

        batchArgs.add(o1);
        batchArgs.add(o2);

        bookService.batchDelete(batchArgs);
    }

}
