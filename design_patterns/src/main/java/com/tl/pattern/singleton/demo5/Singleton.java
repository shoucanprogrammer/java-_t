package com.tl.pattern.singleton.demo4;

public class Singleton {
    //私有构造方法
    private Singleton(){
    }
    //声明Singleton类型的变量
    private static Singleton instance;

    //对外提供公共的访问方式
    public static  Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                //出现空指针  JVM 指令重排
                //第二次判断
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
