package com.tl.pattern.factory.abstract_factory;

import com.tl.pattern.factory.factory_method.Coffee;

public interface DesserFactory {
    //生产咖啡的功能
    Coffee createCoffee();
    //生成甜品的功能
    Dessert createDessert();
}
