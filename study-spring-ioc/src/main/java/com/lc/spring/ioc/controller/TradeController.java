package com.lc.spring.ioc.controller;

import com.lc.spring.ioc.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TradeController {
    @Resource
            @Autowired
    TradeService tradeService;

    public String getItemInfo(long itemId) {
        return tradeService.getItemInfo(itemId);
    }
}
