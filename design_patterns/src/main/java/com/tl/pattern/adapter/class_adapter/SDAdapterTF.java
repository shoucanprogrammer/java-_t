package com.tl.pattern.adapter.class_adapter;

/**
 * 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}
