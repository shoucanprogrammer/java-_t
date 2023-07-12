package com.tl.netty.myrpc.cutomer;

import com.tl.netty.myrpc.netty.NettyClient;
import com.tl.netty.myrpc.publicintereface.HelloService;

public class ClientBootStrap {

    //这里定义协议头
    public static final String providerName = "HelloService#Hello#";
    public static void main(String[] args) throws InterruptedException {

        //创建一个消费者
        NettyClient customer = new NettyClient();

        //创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        //通过代理对象调用服务提供者的方法（服务）
        for (;;) {
            Thread.sleep(2 * 1000);
            String res = service.hello("你好 dubbo~");
            System.out.println("调用的结果 res= " + res);
        }

    }
}
