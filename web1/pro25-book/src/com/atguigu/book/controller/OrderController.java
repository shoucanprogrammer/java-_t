package com.atguigu.book.controller;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.OrderService;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderController {
    private OrderService orderService;
    //结账
    public String checkout(HttpSession session){
        OrderBean orderBean = new OrderBean();
        Date now = new Date();
        int year = now.getYear();
        int month = now.getMonth();
        int date = now.getDate();
        int hours = now.getHours();
        int minutes = now.getMinutes();
        int seconds = now.getSeconds();
        orderBean.setOrderNo(UUID.randomUUID().toString()+" "+year+month+date+hours+minutes+seconds);
        orderBean.setOrderDate(now.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        User user = (User) session.getAttribute("currUser");
        orderBean.setOderUser(user);
        orderBean.setOderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);
        return "index";
    }

    //查看订单列表
    public String getOrderList(HttpSession session){
        User user = (User) session.getAttribute("currUser");

        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser",user);

        return "order/order";
    }


}
