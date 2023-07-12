package com.tl.pattern.builder.demo1;

/**
 * 单车构建者，用来构建ofo单车
 */
public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶坐垫");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
