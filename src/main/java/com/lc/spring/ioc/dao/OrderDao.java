package com.lc.spring.ioc.dao;

import com.lc.spring.zzz.entity.Order;

public interface OrderDao {
    Order getOrder(long orderId);
}
