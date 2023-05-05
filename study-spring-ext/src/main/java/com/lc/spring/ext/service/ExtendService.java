package com.lc.spring.ext.service;

import com.lc.spring.ext.annotation.InjectBO;
import com.lc.spring.ext.annotation.MyInject;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service("extendService")
public class ExtendService {
    @MyInject
    private InjectBO injectBO;

    public InjectBO getInjectBO() {
        return injectBO;
    }

    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("ExtendService监听到的事件：" + event);
            System.out.println("ExtendService监听到的事件：bean加载完成！");
        }
    }
}
