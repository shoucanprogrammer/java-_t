package com.tl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {

        //创建ServerSocketChannel ->ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selector对象
        Selector selector = Selector.open();

        //绑定一个端口6666，在服务端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到  selector关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("注册后的selectionKey数量="+selector.keys().size());
        //循环等待客户端连接
        while (true){

            //这里我们等待1秒钟吗，如果没有事件发生，返回
            if (selector.select(1000) == 0){//没有时间发生
                System.out.println("服务器等待了1s，无连接");
                continue;
            }

            //如果返回的 >0,就获取到相关的selectionKey集合
            //1.如果返回的>0,表示已经获取到的关注时间
            //2.selector.selectedKeys()返回关注事件的集合
            //通过selectionKeys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //遍历Set<SelectionKey>,使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()){
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据这个key对应的通道发生的事件做相应处理
                if (key.isAcceptable()){ //如果是OP_ACCEPT，有新的客户端连接
                    //该客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功 生成了一个socketChannel" + socketChannel.hashCode());
                    //将SocketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector,关注事件为OP_READ，同时给socketChannel
                    //关联一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接后，注册的的selectionKey数量="+selector.keys().size());
                }
                if (key.isReadable()){//发生OP_READ
                    //通过key反向获取到对应channel
                    SocketChannel channel = (SocketChannel)key.channel();
                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    //从channel里读数据放到buffer中
                    channel.read(buffer);
                    System.out.println("from客户端"+new String(buffer.array()));

                }
                //手动从集合中移除当前的selectionKey,防止重复操作
                keyIterator.remove();
            }

        }
    }
}
