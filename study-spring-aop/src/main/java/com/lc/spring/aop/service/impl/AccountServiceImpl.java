package com.lc.spring.aop.service.impl;

import com.lc.spring.aop.annotation.Monitor;
import com.lc.spring.aop.pojo.Result;
import com.lc.spring.aop.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void handleOrderIncome() {
        this.handleOrderIncome(1234567890L, 1234567890L);
    }

    @Override
    @Monitor("orderIncomeMonitor")
    public Result handleOrderIncome(Long sid, Long businessId) {
        System.out.println("handleOrderIncome：处理订单收入...");
        return new Result("success");
    }

    @Override
    @Monitor("bonusImportMonitor")
    public void handleBonusImport(Long sid, Long businessId) {
        System.out.println("handleOrderIncome：处理奖金导入...");
    }
}
