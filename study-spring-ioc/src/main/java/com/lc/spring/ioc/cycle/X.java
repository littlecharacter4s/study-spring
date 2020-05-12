package com.lc.spring.ioc.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class X {
    private Y y;

    @Autowired
    public X(Y y) {
        this.y = y;
    }
}
