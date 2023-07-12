package com.tl.netty.myrpc.provider;

import com.tl.netty.myrpc.netty.NettyServer;

//ServerBootstrap启动一个服务的提供者，就是NettyServer
public class ServerBootstrap {
    public static void main(String[] args) {
        //todo
        NettyServer.startService("127.0.0.1",7000);

    }
}
