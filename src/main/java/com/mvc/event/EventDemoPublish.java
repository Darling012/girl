package com.mvc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 事件发布
@RestController
@RequestMapping("event")
public class EventDemoPublish {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @GetMapping("{msg}")
    public void publish(@PathVariable  String msg) {
        EventDemo demo = new EventDemo(this, msg);
        applicationEventPublisher.publishEvent(demo);
        System.out.println("aaa"+ Thread.currentThread().getName());
    }
}
