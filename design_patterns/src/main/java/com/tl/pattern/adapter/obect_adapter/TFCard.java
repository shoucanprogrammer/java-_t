package com.tl.pattern.adapter.obect_adapter;

/**
 * 适配者类的接口
 */
public interface TFCard {
    //从TF卡中读取数据
    String readTF();
    //从TF卡中写数据
    void writeTF(String msg);
}
