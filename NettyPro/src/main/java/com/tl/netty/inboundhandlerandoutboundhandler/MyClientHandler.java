package com.tl.netty.inboundhandlerandoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("服务器的ip=" + channelHandlerContext.channel().remoteAddress());
        System.out.println("收到服务器消息=" + aLong);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler 发送数据");
        //分析
        ctx.writeAndFlush(123456L);//发送的是一个long
        //1.abcdabcdabcdabcd 是16个字节
        //2.该处理器的前一个前一个handler是MyLongByteEncoder
        //3.MyLongToByteEncoder 父类MessageToByteEncoder
        //4.父类 MessageToByteEncoder
        ctx.writeAndFlush(Unpooled.copiedBuffer("abcdabcdabcdabcd",CharsetUtil.UTF_8));
    }
}
