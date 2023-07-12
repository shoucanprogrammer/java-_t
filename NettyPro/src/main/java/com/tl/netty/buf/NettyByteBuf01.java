package com.tl.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf01 {
    public static void main(String[] args) {


        //创建一个ByteBuf
        //说明
        //1.创建对象，该对象包含一个数组arr,是一个byte[10]
        //2  在netty恶的 buffer中，不需要使用flip进行反转
        // 底层维护了readerIndex  和 writeIndex
        //3.通过readerIndex 和  writerIndex 将buffer分成了三段
        //0--readerIndex 已经 读取的区域
        // readerIndex-- writerIndex，可读区域
        //writerIndex -- capacity

        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++){
            buffer.writeByte(i);
        }
        System.out.println("capacity  = " + buffer.capacity());
        for (int i = 0; i < buffer.capacity(); i++){
            System.out.println(buffer.getByte(i));

        }
        for (int i =  0; i < buffer.capacity(); i++){
            System.out.println(buffer.readByte());
        }
    }
}
