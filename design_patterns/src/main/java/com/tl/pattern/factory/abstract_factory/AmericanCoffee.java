package com.tl.pattern.factory.abstract_factory;

import com.tl.pattern.factory.static_factory.Coffee;

public class AmericanCoffee extends Coffee {

    @Override
    public String getName() {
        return"美式咖啡";
    }
}
