package com.tl.pattern.singleton.demo2;

/**
 * 饿汉式:静态代码块
 */
public class Singleton {

    //私有构造方法
    private Singleton(){}

    //声明Singleton类型的变量
    private static  Singleton instance;

    //在静态代码块中进行赋值
    static {
        instance = new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }
}
