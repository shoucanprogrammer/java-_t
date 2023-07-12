package com.tl.pattern.adapter.class_adapter;

/**
 * 适配者类
 */
public class TFCardImpl implements TFCard{

    @Override
    public String readTF() {
        String msg = "TFCard read msg : hello word TFcard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCar write msg:"+msg);
    }
}
