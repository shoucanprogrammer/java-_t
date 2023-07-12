package com.tl.pattern.adapter.obect_adapter;

import com.tl.pattern.adapter.class_adapter.TFCard;

/**
 * 适配器类
 */
public class SDAdapterTF implements SDCard {
    //声明适配器类
    private TFCard tfCard;
    public SDAdapterTF(TFCard tfCard){
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
