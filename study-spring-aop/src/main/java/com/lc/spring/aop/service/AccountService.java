package com.lc.spring.aop.service;

import com.lc.spring.aop.pojo.Result;

public interface AccountService {
    void handleOrderIncome();
    Result handleOrderIncome(Long sid, Long businessId);
    void handleBonusImport(Long sid, Long businessId);
}
