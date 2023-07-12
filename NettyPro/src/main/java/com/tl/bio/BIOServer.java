package com.tl.bio;

import jdk.net.Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        //线程池机制

        //思路
        //1，创建一个线程池
        //2，如果有客户端连接，就创建一个线程;与之通讯
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建ServerSpcket
        ServerSocket serverSocket = new ServerSocket(6666);  //端口
        System.out.println("服务器启动了");
        while (true){
            System.out.println("线程信息 id = " + Thread.currentThread().getId()+"名字="+Thread.currentThread().getName());
            //监听，等待客户端连接
            System.out.println("等待连接....");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //就创建一个线程，与之通讯
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //可以和客户端通讯
                    handler(socket);
                }
            });
        }
    }
    //编写要给handler方法，和客户端通讯
    public static void handler(Socket socket){
        try {
            System.out.println("线程信息 id = " + Thread.currentThread().getId()+"名字="+Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            //通过socket获取输入流
            InputStream inputStream = socket.getInputStream();

            //循环的读取客户端发送的数据
            while (true){
                System.out.println("线程信息 id = " + Thread.currentThread().getId()+"名字="+Thread.currentThread().getName());
                System.out.println("reading....");
                int read = inputStream.read(bytes);
                if (read != -1){
                    System.out.println(new String(bytes,0,read));//输出客户端发送的数据
                }else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
