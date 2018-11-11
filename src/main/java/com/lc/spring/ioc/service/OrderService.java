package com.lc.spring.ioc.service;

import com.lc.spring.zzz.entity.Order;

public interface OrderService {
    Order getOrder(long orderId);
}
