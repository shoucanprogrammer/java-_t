package com.tl.pattern.factory.abstract_factory;
import com.tl.pattern.factory.factory_method.Coffee;

public class Client {
    public static void main(String[] args) {
        //创建的是意大利风味甜品工厂对象
        ItalyDessertFactory factory = new ItalyDessertFactory();
        //获取拿铁咖啡和提拉米苏甜品
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();
        System.out.println(coffee.getName());
        dessert.show();
    }
}
