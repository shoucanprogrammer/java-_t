package spring5.aopnno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect
@Order(2)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* spring5.aopnno.User.add(..))")
    public void pointdemo(){
    }
    //前置通知
    //@before注解表示作为前置通知
    @Before(value = "pointdemo()")
    public void before(){
        System.out.println("before...");
    }


    @After(value = "pointdemo()")
    public void after(){
        System.out.println("after...");
    }

    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing(){
        System.out.println("afterThrowing...");
    }
    @Around(value = "pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before...");
        proceedingJoinPoint.proceed();
        System.out.println("around after");
    }
}
