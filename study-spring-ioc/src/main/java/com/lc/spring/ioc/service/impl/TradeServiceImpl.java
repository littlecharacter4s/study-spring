package com.lc.spring.ioc.service.impl;

import com.lc.spring.ioc.dao.TradeDao;
import com.lc.spring.ioc.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {
    @Resource
    TradeDao tradeDao;

    @Override
    public String getItemInfo(long itemId) {
        return tradeDao.getItemInfo(itemId);
    }
}
