package com.tl.pattern.prototype.test;

public class Citation implements Cloneable {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
//三好学生的姓名
//    private String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
    public void show(){
        System.out.println(student.getName() + "同学:在2020年获得三好学生");
    }

}
