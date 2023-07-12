package com.tl.pattern.flyweight;

import javax.swing.*;
import java.util.HashMap;

/**
 * 工厂类，将该类设计为单例
 */
public class BoxFactory {
    private HashMap<String,AbstractBox> map;

    //在构造方法中进行初始化操作
    private BoxFactory(){
        map = new HashMap<String,AbstractBox>();
        map.put("I",new IBox());
        map.put("L",new LBox());
        map.put("O",new OBox());
    }
    //提供一个方法获取该工厂类对象
    public static BoxFactory getInstance(){
        return factory;
    }
    private static BoxFactory factory = new BoxFactory();

    //根据名称过去图像对象
    public AbstractBox getShape(String name){
        return map.get(name);
    }
}
