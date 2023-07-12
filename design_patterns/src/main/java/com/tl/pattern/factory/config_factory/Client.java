package com.tl.pattern.factory.config_factory;

/**
 * @Description: TODO(一句话描述该类的功能)
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());

        System.out.println("=============");
        Coffee latte = CoffeeFactory.createCoffee("latte");
        System.out.println(latte.getName());
    }
}
