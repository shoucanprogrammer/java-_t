package com.tl.pattern.singleton.demo3;

/**
 * Singleton
 * 懒汉式
 */
public class Singleton {
    //私有构造方法
    private Singleton(){}

    //声明
    private static Singleton instance;

    //对外提供访问方式
    public static synchronized Singleton getInstance(){
        //判断instance是否位null，如果为null，说明还没有创建Singleton类的对象
        if (instance == null){
            //线程1等待，线程2获取到cpu的执行权，也会进入到该判断里面
            instance = new Singleton();
        }
        return instance;
    }
}
