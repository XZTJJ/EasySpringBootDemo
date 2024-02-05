package com.zhouhc.demo.linstener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyLinstener{
    @EventListener
    public void started(ApplicationStartedEvent applicationStartedEvent){
        System.out.println("调用了ApplicationStartedEvent的started()");
    }

    @EventListener
    public void ready(ApplicationReadyEvent applicationReadyEvent){
        System.out.println("调用了ApplicationReadyEvent的ready()");
    }
}
