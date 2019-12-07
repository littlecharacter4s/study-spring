package com.lc.spring.mvc;

import com.lc.spring.mvc.config.MvcConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MvcTest {
    @Test
    public void testTx() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MvcConfig.class);

        applicationContext.close();
    }
}