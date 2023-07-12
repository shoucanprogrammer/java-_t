package com.tl.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

public class NettyByteBuf02 {
    public static void main(String[] args) {
        //创建ByteBuf
        ByteBuf buf = Unpooled.copiedBuffer("hello,world!", Charset.forName("utf-8"));

        //使用相关的方法
        if (buf.hasArray()){//true
            byte[] content = buf.array();

            //将content转成字符串
            System.out.println(new String(content, Charset.forName("utf-8")));

            System.out.println(buf.arrayOffset());
            System.out.println(buf.readerIndex());
            System.out.println(buf.writerIndex());
            System.out.println(buf.capacity());
            int len = buf.readableBytes();
            System.out.println(len);
            buf.readByte();
            len = buf.readableBytes();
            System.out.println(len);

            System.out.println(buf.getCharSequence(0,4,Charset.forName("utf-8")));
        }


    }
}
