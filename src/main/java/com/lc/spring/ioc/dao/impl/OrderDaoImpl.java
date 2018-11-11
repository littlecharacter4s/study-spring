package com.lc.spring.ioc.dao.impl;

import com.lc.spring.ioc.dao.OrderDao;
import com.lc.spring.zzz.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order getOrder(long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setMoney(1000L);
        order.setBuyer("zs");
        order.setSeller("ls");
        return order;
    }
}
