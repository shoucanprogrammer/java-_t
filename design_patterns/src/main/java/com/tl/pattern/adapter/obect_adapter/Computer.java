package com.tl.pattern.adapter.class_adapter;

public class Computer {

    //从SD卡中读取数
    public String readSD(SDCard sdCard){
        if (sdCard == null){
            throw  new NullPointerException("sd card is null");
        }
        return sdCard.readSD();
    }
}
