package com.tl.principles.demo2.after.Quadrilateral;

/**
 * 正方形
 */
public class Square implements Quadrialteral{

    private double side;



    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}
