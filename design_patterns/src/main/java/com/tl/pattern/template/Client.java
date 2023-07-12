package com.tl.pattern.template;

public class Client {
    public static void main(String[] args) {
        //抄包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        //调用炒菜的功能
        baoCai.cookProcess();


        //抄菜心
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
