package com.lc.spring.ioc.lifecycle;

public class Lifecycle01 {
    public Lifecycle01() {
        System.out.println("Lifecycle01：实例化...");
    }

    public void init() throws Exception {
        System.out.println("Lifecycle01：初始化...");
    }

    public void destroy() throws Exception {
        System.out.println("Lifecycle01：销毁...");
    }
}
