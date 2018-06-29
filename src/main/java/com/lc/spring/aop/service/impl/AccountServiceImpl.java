package com.lc.spring.aop.service.impl;

import com.lc.spring.aop.service.AccountService;
import com.lc.spring.zzz.annotation.Monitor;
import com.lc.spring.zzz.pojo.Result;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void handleOrderIncome() {
        this.handleOrderIncome(111111111L, 27L);
    }

    @Override
    @Monitor("orderIncomeMonitor")
    public Result handleOrderIncome(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理订单收入!");
        return new Result("success");
    }

    @Override
    @Monitor("bonusImportMonitor")
    public Object handleBonusImport(Long sid, Long businessId) {
        System.out.println("handleOrderIncome:处理奖金导入!");
        return null;
    }
}
