package com.tl.netty.heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))//在bossGroup增加一个日志处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            //加入一个Netty提供IdleSateHandler
                            /**
                             * 说明
                             * 1.IdleStateHandler 是netty提供的处理空闲状态的处理器
                             *  readerIdleTime：表示多长时间没有读，就会发送一个心跳检测包检测是否连接
                             *  writerIdleTime：表示多长时间没有写，就会发送一个心跳检测包检测是否连接
                             *  allIdleTime：表示多长时间没有读写，就会发送一个心跳检测包检测是否连接
                             */
                            //当IdleStateHandler触发后，就会传递给管道的下一个handler去处理
                            //通过调用（触发）下一个handler的userEventTriggered，在该方法中去处理IdleStateHandler
                            //事件
                            pipeline.addLast(new IdleStateHandler(
                                    3,5,7, TimeUnit.SECONDS));
                            //加入对一个空闲检测进一步处理的handler(自定义)
                            pipeline.addLast(new MyServerHandler());
                        }
                    });
            //启动服务器
            ChannelFuture channelFuture = bootstrap.bind(7000).sync();
            //监听关闭事件
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


}
