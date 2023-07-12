package com.tl.pattern.singleton.demo2;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        //判断两次获取到的对象是否是同一个

        System.out.println(instance == instance1);
    }
}
