package com.tl.pattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        //创建手机对象  通过构建者对象获取手机对象
        Phone phone = new Phone.Builder()
                .cpu("intel").mainBoard("华硕").memory("金士顿").screen("三星").build();
        System.out.println(phone);
    }
}
