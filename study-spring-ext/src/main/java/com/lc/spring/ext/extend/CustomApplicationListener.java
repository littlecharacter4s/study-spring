package com.lc.spring.ext.extend;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * 监听ApplicationEvent事件
 */
@Component
public class CustomApplicationListener implements ApplicationListener<ApplicationEvent> {
    //当容器中发布此事件以后，方法触发，
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("CustomApplicationListener收到事件：" + event);
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("CustomApplicationListener监听到的事件：bean加载完成！");
        }
    }
}
