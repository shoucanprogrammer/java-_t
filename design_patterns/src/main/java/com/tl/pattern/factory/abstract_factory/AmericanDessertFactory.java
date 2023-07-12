package com.tl.pattern.factory.abstract_factory;

import com.tl.pattern.factory.factory_method.AmericanCoffee;
import com.tl.pattern.factory.factory_method.Coffee;

/**
 * 美式风味的甜品工厂
 * 生成美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DesserFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchMousse();
    }
}
