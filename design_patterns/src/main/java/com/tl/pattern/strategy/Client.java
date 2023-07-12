package com.tl.pattern.strategy;

public class Client {
    public static void main(String[] args) {
        Strategy strategyA = new StrategyA();
        SalesMan salesMan = new SalesMan(strategyA);
        salesMan.salesManShow();
    }
}
