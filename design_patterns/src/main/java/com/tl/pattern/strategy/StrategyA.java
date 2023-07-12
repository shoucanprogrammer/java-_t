package com.tl.pattern.strategy;

/**
 * 具体策略类,封装算法
 */
public class StrategyA implements Strategy{
    public void show(){
        System.out.println("买一送一");
    }
}
