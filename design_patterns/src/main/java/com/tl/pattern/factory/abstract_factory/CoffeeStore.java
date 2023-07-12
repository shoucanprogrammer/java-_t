package com.tl.pattern.factory.abstract_factory;

import com.tl.pattern.factory.static_factory.Coffee;
import com.tl.pattern.factory.static_factory.SimpleCoffeeFactory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){

        //调用生产咖啡的方法
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);
        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
