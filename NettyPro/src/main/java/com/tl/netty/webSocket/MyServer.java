package com.tl.netty.webSocket;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

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

                            //因为基于http协议，使用http的编码和解码器
                            pipeline.addLast(new HttpServerCodec());
                            //是以块的方式写,添加ChunkedWrite处理器
                            pipeline.addLast(new ChunkedWriteHandler());
                            /*
                                说明
                                1.http数据在传输过程中是分段的，HttpObjectAggregator，就是可以将多个段聚合
                                2.这就是为什么，当浏览器发送大量数据时，就会发送多次http请求
                             */
                            pipeline.addLast(new HttpObjectAggregator(8192));
                            /*
                            说明
                            1.对应webSocket，他的数据是以帧（frame）形式传递
                            2.可以看到webSocketFrame，下面有六个子类
                            3.浏览器请求时ws://localhost:7000/hello 表示请求的uri
                            4.WebSocketServerProtocolHandler核心功能是将http协议升级为ws协议，保持长连接

                            5.是通过一个状态码 101进行切换
                             */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                            //自定义的handler
                            pipeline.addLast(new MyTextWebSocketFrameHandler());
                        }
                    });
            //启动服务器
            ChannelFuture channelFuture = bootstrap.bind(7001).sync();
            //监听关闭事件
            channelFuture.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


}
