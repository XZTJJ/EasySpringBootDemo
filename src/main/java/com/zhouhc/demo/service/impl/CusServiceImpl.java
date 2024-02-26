package com.zhouhc.demo.service.impl;

import com.zhouhc.demo.po.MyPoJo;
import com.zhouhc.demo.service.CusService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//自定义服务
@Service
public class CusServiceImpl implements CusService, ApplicationContextAware, BeanNameAware {

    @Autowired
    private MyPoJo myPoJo;

    @Value("${cus.five:5}")
    private Integer five;

    @Override
    public String invoke() {
        return String.format("invoke method myPoJo:%s %n", myPoJo);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用了CusServiceImpl的setBeanName()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("调用了CusServiceImpl的setApplicationContext()");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("调用了CusServiceImpl的PreDestroy()");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("调用了CusServiceImpl的postConstruct()");
    }
}
