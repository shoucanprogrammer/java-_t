package com.tl.netty.codec2;

import com.tl.netty.codec.StudentPOJO;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.Random;

/**
 * 说明
 * 1.我们自定义一个Handler 需要继续netty规定好的某个HandlerAdapter(规范)
 * 2.这时我们定义一个Handler，才能成为一个handler
 */

//继承SimpleChannelInboundHandler<StudentPOJO.Student>
//public class NettyServerHandler extends ChannelInboundHandlerAdapter {
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    //读取数据实际（这里我们可以读取客户端发送的消息）
//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, StudentPOJO.Student msg) throws Exception {
//        //读取从客户端发送的StudentPojo.Student
//        StudentPOJO.Student student = (StudentPOJO.Student)msg;
//        System.out.println("客户端发送的数据 id = "+student.getId() + "名字="+ student.getName());
//    }
    /**
     *读取实际数据
     * @param ctx 上下文对象，含有管道pipeline，通道channel，地址
     * @param msg 客户端发送的数据，默认Object
     * @throws Exception
     */
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//       //读取从客户端发送的StudentPojo.Student
//        StudentPOJO.Student student = (StudentPOJO.Student)msg;
//        System.out.println("客户端发送的数据 id = "+student.getId() + "名字="+ student.getName());
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        //根据dataType来显示不同的信息
        MyDataInfo.MyMessage.DateType dataType = msg.getDataType();
        if (dataType == MyDataInfo.MyMessage.DateType.StudentType){
            MyDataInfo.Student student = msg.getStudent();
            System.out.println("学生id = "+ student.getId() + "学生name"+ student.getName());
        }else if (dataType == MyDataInfo.MyMessage.DateType.WorkerType){
            MyDataInfo.Worker worker = msg.getWorker();
            System.out.println("工人的名字="+ worker.getName() + "年龄=" + worker.getAge());
        }else {
            System.out.println("传输的类型不正确");
        }
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //writeAndFlush是write + flush
        //将数据写入到缓存，并且刷新
        //一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端~:(>^w^<)喵1",CharsetUtil.UTF_8));

    }

    //处理异常，一般是需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }


}
