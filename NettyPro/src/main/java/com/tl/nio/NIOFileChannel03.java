package com.tl.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileStream02 = new FileOutputStream("2.txt");
        FileChannel fileChannel02 = fileStream02 .getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true){//循环读取
            //这里有个重要操作
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer);
            if (read == -1){//表示读完毕
                break;
            }
            //将buffer中的数据写入到fileChannel02 -- 2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }
        //关闭相关的流
        fileInputStream.close();
        fileStream02.close();
    }
}
