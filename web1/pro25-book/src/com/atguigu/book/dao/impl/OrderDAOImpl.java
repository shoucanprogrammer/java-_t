package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.OrderDAO;
import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;


public class OrderDAOImpl extends BaseDAO<OrderBean>  implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",
                orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOderUser().getId(),
                orderBean.getOderMoney(), orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);
        //思考：；此处为什么需要接受executeUpdate的返回值，然后设置到OrderBean中的id属性上？
        //为了删除
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        return executeQuery("SELECT * FROM t_order WHERE orderUser = ?",user.getId());
    }
}
