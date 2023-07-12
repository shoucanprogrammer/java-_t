package com.tl.netty.myrpc.provider;

import com.tl.netty.myrpc.publicintereface.HelloService;

public class HelloServiceImpl implements HelloService {
    private static int count = 0;

    //当有消费调用该方法时，就返回一个结果
    @Override
    public String hello(String mes) {
        System.out.println("收到客户端消息="+mes);
        if (mes != null){
            return "你好客户端,我已经收到了你的消息["+mes+"] 第" + (++count) + "" ;
        }else {
            return "你好客户端,我已经收到了你的消息";
        }
    }
}