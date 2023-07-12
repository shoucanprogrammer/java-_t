package com.tl.pattern.factory.static_factory;

public class Client {
    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore();
        //点咖啡
        Coffee coffee = store.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}
