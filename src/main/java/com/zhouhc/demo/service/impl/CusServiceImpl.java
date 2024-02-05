package com.zhouhc.demo.service.impl;

import com.zhouhc.demo.po.MyPoJo;
import com.zhouhc.demo.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//自定义服务
@Service
public class CusServiceImpl implements CusService {

    @Autowired
    private MyPoJo myPoJo;

    @Override
    public String invoke() {
        return String.format("invoke method myPoJo:%s %n", myPoJo);
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("调用了CusServiceImpl的PreDestroy()");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("调用了CusServiceImpl的postConstruct()");
    }
}
