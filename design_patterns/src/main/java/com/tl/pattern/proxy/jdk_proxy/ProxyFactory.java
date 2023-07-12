package com.tl.pattern.proxy.jdk_proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 */
public class ProxyFactory {
    //声明目标对象
    private TrainStation station = new TrainStation();

    //获取代理对象的方法
    public SellTickets getProxyObject(){
        //返回代理对象
        /*
        ClassLoader loader, 类加载器
        Class<?>[] interfaces, 代理类实现的接口的字节码对象
        InvocationHandler h   代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代售点收取一定的服务费用(JDK动态代理)");
                       System.out.println("invoke方法执行了");
                       //执行目标对象的方法
                        Object obj = method.invoke(station, args);
                        return obj;
                    }
                }
        );
        return proxyObject;
    }
}
