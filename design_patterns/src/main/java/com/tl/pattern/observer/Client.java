package com.tl.pattern.observer;

public class Client {
    public static void main(String[] args) {
        //创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        //订阅公众号
        subject.attach(new WeiXinUser("孙悟空"));
        subject.attach(new WeiXinUser("猪悟能"));
        subject.attach(new WeiXinUser("沙悟净"));

        //公众号更新，发出消息给订阅者对象(观察者对象)
        subject.notify("专栏更新了");
    }
}
