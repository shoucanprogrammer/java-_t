package com.tl.pattern.decorator;

/**
 * 培根类（具体的装饰者类）
 */
public class Bacon extends Garnish{

    public Bacon(FastFood fastFood){
        super(fastFood,2,"培根");
    }
    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
