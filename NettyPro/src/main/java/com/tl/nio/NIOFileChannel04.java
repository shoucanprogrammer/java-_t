package com.tl.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NIOFileChannel04 {
    public static void main(String[] args) throws IOException {
        //创建相关的流
        FileInputStream fileInputStream = new FileInputStream("a.png");
        FileOutputStream fileOutputStream = new FileOutputStream("a2.jpg");

        //获取各个流的fileChannel
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        //使用transferForm完成拷贝
        outputStreamChannel.transferFrom(inputStreamChannel,0,inputStreamChannel.size());

        //关闭相关的liu
        inputStreamChannel.close();
        outputStreamChannel.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
