package com.tl.pattern.proxy.static_proxy;

public class Client {
    public static void main(String[] args) {
        //创建待售点类对象
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }
}
