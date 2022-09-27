package com.atguigu.book.service.impl;

import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.dao.OrderDAO;
import com.atguigu.book.dao.impl.OrderItemDAOImpl;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.OrderItem;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO;
    private OrderItemDAOImpl orderItemDAO;
    private CartItemDAO cartItemDAO;
    @Override
    public void addOrderBean(OrderBean orderBean) {
        //1.订单表添加一条记录
        //2.订单详情表添加7条记录
        //3.购物车项表需要删除对应的7条记录
        //第一步
        orderDAO.addOrderBean(orderBean);  //执行完这步，orderBea中id是有值的
        //第二步
        User currUser = orderBean.getOderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()){
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        //第三步：
        for (CartItem cartItem : cartItemMap.values()){
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        return orderDAO.getOrderList(user);
    }
}
