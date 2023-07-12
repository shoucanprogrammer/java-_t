package com.tl.principles.demo2.defore;

public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle r = new Rectangle();
        r.setLength(20);
        r.setWidth(10);

        resize(r);
        printLengthAndWidth(r);
        System.out.println("=========");
        //创建长方形对象
        Square s = new Square();
        s.setLength(10);
        resize(s);
        printLengthAndWidth(r);

    }
    //扩宽方法
    public static void resize(Rectangle rectangle){
        //判断宽如果比长校，进行扩宽的操作
        while (rectangle.getWidth() <= rectangle.getLength()){
            rectangle.setWidth(rectangle.getWidth()+1);
        }
    }
    //打印长和宽

    public static void printLengthAndWidth(Rectangle rectangle){
        System.out.println("长："+rectangle.getLength());
        System.out.println("宽："+rectangle.getWidth());
    }
}
