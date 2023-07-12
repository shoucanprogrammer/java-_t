package com.tl.pattern.proxy.CGLIB_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理对象工厂，用来获取代理对象
 */
public class ProxyFactory implements MethodInterceptor {
    //声明火车站对象
    private TrainStation station = new TrainStation();
    public TrainStation getProxyObject(){
        //创建Enhancer对象，类似于JDK代理中的Proxy类
        Enhancer enhancer = new Enhancer();
        //设置弗雷的字节码对象
        enhancer.setSuperclass(TrainStation.class);
        //设置回调函数
        enhancer.setCallback(this);
        //创建代理对象
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       System.out.println("代售点收取一定费用");
       //调用目标对象的方法；
        Object obj = method.invoke(station, objects);

        return null;
    }
}
