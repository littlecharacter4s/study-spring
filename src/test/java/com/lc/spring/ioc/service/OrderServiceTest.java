package com.lc.spring.ioc.service;

import com.alibaba.fastjson.JSON;
import com.lc.spring.zzz.util.SpringUtil;
import org.junit.Test;

public class OrderServiceTest {
    @Test
    public void testGetOrder() throws Exception {
        OrderService service = SpringUtil.getBean(OrderService.class);
        System.out.println(JSON.toJSONString(service.getOrder(20181111111111L)));
    }
}