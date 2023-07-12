package com.tl.pattern.adapter.obect_adapter;

import com.tl.pattern.adapter.class_adapter.TFCardImpl;

public class Client {
    public static void main(String[] args) {
        //创建计算机对象
        Computer computer = new Computer();
        //读取SD卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("====================");
        //使用该电脑读取TF卡中的数据
        //定义适配器类
        String msg1 = computer.readSD(new SDAdapterTF(new TFCardImpl()));
        System.out.println(msg1);
    }
}
