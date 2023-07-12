package com.tl.pattern.adapter.class_adapter;

/**
 * 具体的SD卡
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        String msg = "SDCard read msg : hello word SD";
        return msg;

    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg : " + msg);
    }
}
