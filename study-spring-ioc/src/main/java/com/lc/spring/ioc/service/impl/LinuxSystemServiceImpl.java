package com.lc.spring.ioc.service.impl;

import com.lc.spring.ioc.service.SystemService;

public class LinuxSystemServiceImpl implements SystemService {
    @Override
    public String hello() {
        return "I am linux system service.";
    }
}
