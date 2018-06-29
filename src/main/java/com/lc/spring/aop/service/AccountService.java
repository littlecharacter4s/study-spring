package com.lc.spring.aop.service;

import com.lc.spring.zzz.pojo.Result;

public interface AccountService {
    void handleOrderIncome();
    Result handleOrderIncome(Long sid, Long businessId);
    Object handleBonusImport(Long sid, Long businessId);
}
