package com.lc.spring.ioc.service.impl;

import com.lc.spring.ioc.service.SystemService;

public class WindowsSystemServiceImpl implements SystemService {
    @Override
    public String hello() {
        return "I am windows system service.";
    }
}
