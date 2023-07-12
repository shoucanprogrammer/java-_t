package com.tl.pattern.factory.abstract_factory;

import com.tl.pattern.factory.factory_method.Coffee;
import com.tl.pattern.factory.factory_method.LatteCoffee;

/**
 * 意大利风味甜品工厂
 * 生产拿铁咖啡和提拉米苏
 */
public class ItalyDessertFactory implements DesserFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
