package com.atguigu.book.pojo;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

public class OrderBean {
    private Integer id;
    private String orderNo;
    private LocalDateTime orderDate;
    private User orderUser;
    private Double orderMoney;
    private Integer orderStatus;

    private List<OrderItem> orderItemList;
    public OrderBean(){}
    public OrderBean(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getOderUser() {
        return orderUser;
    }

    public void setOderUser(User oderUser) {
        this.orderUser = oderUser;
    }

    public Double getOderMoney() {
        return orderMoney;
    }

    public void setOderMoney(Double oderMoney) {
        this.orderMoney = oderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
