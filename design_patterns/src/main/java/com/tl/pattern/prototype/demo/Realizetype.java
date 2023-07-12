package com.tl.pattern.prototype.demo;

public class Realizetype implements Cloneable{
    public Realizetype(){
        System.out.println("具体的原型对象创建完成!");
    }

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型赋值成功");
        return (Realizetype) super.clone();
    }
}
