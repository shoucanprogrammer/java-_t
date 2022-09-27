package com.atguigu.book.pojo;

import java.util.Date;
import java.util.List;

public class OrderBean {
    private Integer id;
    private String orderNo;
    private Date orderDate;
    private User oderUser;
    private Double oderMoney;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getOderUser() {
        return oderUser;
    }

    public void setOderUser(User oderUser) {
        this.oderUser = oderUser;
    }

    public Double getOderMoney() {
        return oderMoney;
    }

    public void setOderMoney(Double oderMoney) {
        this.oderMoney = oderMoney;
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
