package com.tl.pattern.prototype.test;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1 创建原型对象
        Citation citation = new Citation();
        Student stu = new Student();
        stu.setName("张三");
        citation.setStudent(stu);
        //2 克隆 奖状对象
        Citation citation1 = citation.clone();
        citation1.getStudent().setName("李四");
        citation1.show();
        citation.show();
    }
}
