package com.tl.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.*;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {
    //使用一个hashmap管理
    public static Map<String,Channel> channels= new HashMap<String,Channel>();


//    public static List<Channel> channels = new ArrayList<>();
    //定义一个channel组，
    //GlobalEventExecutor 是AbstractScheduledEventExecutor
    // 的实现，就是提供了一个单线程的单例，然后自动启动线程去执行任务 是全局的事件执行器
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD:HH:mm:ss");

    //表示连接建立，一旦连接，第一个被执行
    //将当前channel加入到channelGroup
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户加入聊天的信息推送给其他在线的客户端
        /**
         * 该方法会将 channelGroup中所有的channel遍历，并发送消息
         * 我们不需要自己遍历
         */
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() +"  "+sdf.format(new Date())+" 加入聊天~\n");
        channelGroup.add(channel);

        channels.put("Id100",channel);
    }

    //表示channel处于活动的状态，提示xx上线了
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"上线了~");
    }


    //表示channel 处于不活动状，提示xx下线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "离线了~");
    }

    //断开连接，将某某客户离开信息推送给当前在线的客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]" + channel.remoteAddress() + "离开了\ns");
        System.out.println("当前channelGroup size" + channelGroup.size());

    }

    //读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取到当前channel
        Channel channel = ctx.channel();
        //这时我们遍历channelGroup
        channelGroup.forEach(channel1 -> {
            if (channel != channel1){//不是当前channel，直接转发
                channel1.writeAndFlush("[客户]"+channel.remoteAddress()+"发送了消息"+msg + "\n");
            }else {
                channel1.writeAndFlush("[自己]"+channel.remoteAddress()+"发送了消息"+msg + "\n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //关闭通道
       System.out.println("异常发生"+cause.getMessage());
       ctx.close();//关闭连接
    }
}
