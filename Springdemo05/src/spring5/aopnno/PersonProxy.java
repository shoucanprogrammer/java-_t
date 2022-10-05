package spring5.aopnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PersonProxy {
    //后置通知
    @Before(value ="execution(* spring5.aopnno.User.add(..))")
    public void afterReturning(){
        System.out.println("Person Before....");
    }
}
