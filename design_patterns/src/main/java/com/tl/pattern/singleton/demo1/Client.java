package com.tl.pattern.singleton.demo1;

public class Client {
    public static void main(String[] args) {
        //创建Singletion类的对象
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        //判断获取两个是否是同一个对象
        System.out.println(instance == instance1);
    }
}
