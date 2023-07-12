package com.tl.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel01 {
    public static void main(String[] args) throws IOException {
        String str = "hello,你好。";

        //创建一个输出流 ->channel
        FileOutputStream fileOutputStream = new FileOutputStream("G:\\file01.txt");

        //通过 fileOutputStream 获取对应的FileChannel
        //这个fileChannel真实类型是 FileChannelImp
        FileChannel fileChannel = fileOutputStream.getChannel();

        //创建一个缓冲区ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将str放入byteBuffer
        byteBuffer.put(str.getBytes());

        //对bytebuffer进行flip
        byteBuffer.flip();

        //将byteBuffer数据写入到fileChannel中
        fileChannel.write(byteBuffer);
        fileOutputStream.close();

    }
}
