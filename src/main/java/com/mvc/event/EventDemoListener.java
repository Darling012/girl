package com.mvc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// 定义一个事件监听者
@Component
public class EventDemoListener implements ApplicationListener<EventDemo> {
    @Override
    @Async
    public void onApplicationEvent(EventDemo event) {
        System.out.println("receiver " + event.getMessage()+ Thread.currentThread().getName());
    }
}
