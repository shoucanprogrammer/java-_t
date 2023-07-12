package com.tl.pattern.proxy.jdk_proxy;

public class Client {
    public static void main(String[] args) {
        //获取代理对象
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //使用factory对象的方法获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        //调用卖电脑的方法
        proxyObject.sell();

    }
}
