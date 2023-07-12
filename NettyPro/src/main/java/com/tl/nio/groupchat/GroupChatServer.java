package com.tl.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {
    //定义相关的属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;

    //构造器
    //初始化工作
    public GroupChatServer(){
        try {
            //得到选择器
            selector = Selector.open();
            //获取到ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将该listChannel注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //监听
    public void listen(){
        System.out.println("监听线程"+ Thread.currentThread().getName());
        try {
            //循环处理
            while (true){
                int count = selector.select();
                if (count > 0){//有事件处理
                    //遍历得到selectionKey 集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()){
                        //取出selecttonkey
                        SelectionKey key = iterator.next();

                        //监听到accept
                        if (key.isAcceptable()){
                            SocketChannel sc = listenChannel.accept();
                            //设置非阻塞
                            sc.configureBlocking(false);
                            //将该sc注册到seletor
                            sc.register(selector,SelectionKey.OP_READ);
                            //提示
                            System.out.println(sc.getRemoteAddress() + "上线");
                        }

                        if (key.isReadable()){//通道发生read事件，即通道是可读的状态
                            //处理读(专门写方法)
                            readDate(key);
                        }
                        //当前的key删除，防止重复处理
                        iterator.remove();
                    }
                }else {
                    System.out.println("等待");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }

    }

    //编写读取客户端消息
    private void readDate(SelectionKey key){
        //取到关联的channel
        SocketChannel channel = null;
        try {
            //得到channel
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            //根据count的值做处理
            if (count > 0){
                //把缓存区的数据转换成字符串
                String msg = new String(buffer.array());
                System.out.println("from 客户端:"+ msg);

                //向其他的客户端转发消息(去掉自己)，专门写一个方法来处理
                sendInfoToOtherClients(msg,channel);


            }
        }catch (IOException e){
            try {
                System.out.println(channel.getRemoteAddress()+"离线了...");
                //取消注册
                key.cancel();
                //关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    //转发消息给其他客户(通道)
    private void sendInfoToOtherClients(String msg,SocketChannel self) throws IOException {
        System.out.println("服务器转发给客户端线程"+ Thread.currentThread().getName());
        System.out.println("服务器转发消息中...");
        //遍历 所有注册到selector上的 SocketChannel，并排除self
        for (SelectionKey key : selector.keys()){

            //通过key 取出对应的SocketChannel
           Channel targetChannel = key.channel();

           //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self){
                //转型
               SocketChannel dest=(SocketChannel)targetChannel;
               //将msg存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer的数据写入到通道
                dest.write(buffer);
            }

        }


    }


    public static void main(String[] args) {
        //创建服务器对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();

    }


}


class MyHandler {
    public void readDate(){}

    public void sendInfoToOtherClients(){}
}