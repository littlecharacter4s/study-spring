package com.lc.spring.ext.service;

import com.lc.spring.ext.annotation.InjectBO;
import com.lc.spring.ext.annotation.MyInject;
import org.springframework.stereotype.Service;

@Service
public class InjectService {
    @MyInject
    private InjectBO injectBO;

    public InjectBO getInjectBO() {
        return injectBO;
    }
}
