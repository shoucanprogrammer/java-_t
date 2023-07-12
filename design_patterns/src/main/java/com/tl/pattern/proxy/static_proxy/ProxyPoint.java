package com.tl.pattern.proxy.static_proxy;

/**
 * 代售点
 */
public class ProxyPoint implements SellTickets{
    //声明火车站类对象
    private  TrainStation trainStation = new TrainStation();


    @Override
    public void sell() {
        System.out.println("收取一些服务费用");
        trainStation.sell();
    }
}
