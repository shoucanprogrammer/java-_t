package com.tl.pattern.prototype.test1;

import java.io.Serializable;

public class Student implements Serializable {
    //学生的姓名
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
