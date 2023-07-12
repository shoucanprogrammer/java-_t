package com.tl.pattern.builder.demo1;

/**
 * 具体的建设者，
 */
public class MobileBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车架");

    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
