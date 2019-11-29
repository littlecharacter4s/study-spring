package com.lc.spring.aop.service.impl;

import com.alibaba.fastjson.JSON;
import com.lc.spring.aop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrederInfo(long orderId) {
        Map<String, Object> map = new HashMap<>(8);
        long newOrderId = orderId + 1 / orderId;
        map.put("id", newOrderId);
        map.put("itemId", 1234567890L);
        map.put("buyerId", 1234567890L);
        map.put("sellerId", 1234567890L);
        map.put("price", 100500L);
        map.put("amount", 2);
        map.put("money", 201000L);
        map.put("desc", "购买筑基丹2粒，总额201元");
        String orderInfo = JSON.toJSONString(map);
        System.out.println("订单信息：" + orderInfo);
        return orderInfo;
    }
}
