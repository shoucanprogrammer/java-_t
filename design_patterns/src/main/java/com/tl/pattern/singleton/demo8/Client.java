package com.tl.pattern.singleton.demo8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1 获取Singleton的字节码对象
        Class<Singleton> clazz = Singleton.class;
        //2 获取无参构造方法
        Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
        //3 取消访问检测
        constructor.setAccessible(true);
        //4 创建Singleton对象
        Singleton s1 = constructor.newInstance();
        Singleton s2 = constructor.newInstance();
        System.out.println(s1 == s2);
    }
}
