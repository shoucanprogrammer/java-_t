package com.tl.pattern.strategy;

/**
 * 销售员
 */
public class SalesMan {
    //聚合策略对象
    private Strategy strategy;

    public SalesMan(Strategy strategy){
        this.strategy = strategy;
    }

    //由促销员展示促销活动给用户
    public void salesManShow(){
        strategy.show();
    }
}
