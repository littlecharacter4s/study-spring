package com.lc.spring.ioc.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Y {
    private X x;

    @Autowired
    public Y(X x) {
        this.x = x;
    }
}
