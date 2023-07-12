package com.tl.pattern.strategy;

/**
 * 具体策略类,封装算法
 */
public class StrategyB implements Strategy{
    public void show(){
        System.out.println("满200减50");
    }
}
