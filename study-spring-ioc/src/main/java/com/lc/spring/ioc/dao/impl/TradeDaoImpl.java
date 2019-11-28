package com.lc.spring.ioc.dao.impl;

import com.alibaba.fastjson.JSON;
import com.lc.spring.ioc.dao.TradeDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("tradeDao")
public class TradeDaoImpl implements TradeDao {
    @Override
    public String getItemInfo(long itemId) {
        Map<String, Object> map = new HashMap<>(8);
        map.put("id", itemId);
        map.put("name", "筑基丹");
        map.put("owner", "韩立");
        map.put("price", 100500L);
        map.put("desc", "筑基丹，用于突破瓶颈筑基");
        return JSON.toJSONString(map);
    }
}
