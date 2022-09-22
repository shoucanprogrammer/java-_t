package com.atguigu.myssm.exceptions;

public class DAOException extends RuntimeException{
    public DAOException(String msg){
        super(msg);
    }
}