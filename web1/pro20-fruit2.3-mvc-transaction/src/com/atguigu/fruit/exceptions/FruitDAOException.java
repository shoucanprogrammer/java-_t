package com.atguigu.fruit.exceptions;

import com.atguigu.fruit.pojo.Fruit;

public class FruitDAOException extends RuntimeException{
    public FruitDAOException(String msg){
        super(msg);
    }
}
