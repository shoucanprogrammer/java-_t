package com.tl.pattern.proxy.jdk_proxy;

/**
 * 火车站买票
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
