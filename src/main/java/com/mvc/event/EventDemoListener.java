package com.mvc.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

// 定义一个事件监听者
@Component
@Slf4j
public class EventDemoListener implements ApplicationListener<EventDemo> {
    @Override
    @Async("asyncServiceExecutor")
    public void onApplicationEvent(EventDemo event) {

        System.out.println("receiver " + event.getMessage() + Thread.currentThread()
                                                                    .getName());
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        log.info("requestAttributes-------{}", requestAttributes.getAttribute("hello", 0));
    }
}
