package com.tl.pattern.factory.static_factory.simple_factory;

public class CoffeeStore {
    public Coffee orderCoffee(String type){
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        //调用生产咖啡的方法
        Coffee coffee = factory.createCoffee(type);

        //加配料
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
