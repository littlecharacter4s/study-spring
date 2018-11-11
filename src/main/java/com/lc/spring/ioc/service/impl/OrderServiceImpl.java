package com.lc.spring.ioc.service.impl;

import com.lc.spring.ioc.dao.OrderDao;
import com.lc.spring.ioc.service.OrderService;
import com.lc.spring.zzz.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order getOrder(long orderId) {
        return orderDao.getOrder(orderId);
    }
}
