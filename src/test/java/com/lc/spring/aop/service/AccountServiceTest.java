package com.lc.spring.aop.service;

import com.lc.spring.zzz.util.SpringUtil;
import org.junit.Test;

public class AccountServiceTest {
    @Test
    public void testMonitor () {
        AccountService service = SpringUtil.getBean(AccountService.class);
        service.handleOrderIncome(111111111L, 27L);
        service.handleBonusImport(111111111L, 27L);
        service.handleOrderIncome(); //aop的原理是动态代理，这里没有用到代理类，而是用this，所以监控不到
    }
}