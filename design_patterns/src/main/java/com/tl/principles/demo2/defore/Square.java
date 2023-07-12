package com.tl.principles.demo2.defore;

/**
 * 正方形类
 */
public class Square extends Rectangle {
    @Override
    public void setLength(double length){
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width){
        super.setLength(width);
        super.setWidth(width);
    }
}
