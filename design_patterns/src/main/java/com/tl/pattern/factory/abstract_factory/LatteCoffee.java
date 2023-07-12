package com.tl.pattern.factory.abstract_factory;

import com.tl.pattern.factory.static_factory.Coffee;

public class LatteCoffee extends Coffee {

    @Override
    public String getName() {
        return "拿铁咖啡";
    }
}
