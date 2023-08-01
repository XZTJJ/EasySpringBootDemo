package com.zhouhc.demo.service.impl;

import com.zhouhc.demo.po.MyDate;
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
    private MyDate myDate;
    @Autowired
    private MyPoJo myPoJo;

    @Override
    public String invoke() {
        return String.format("invoke method myDate:%s myPoJo:%s %n", myDate, myPoJo);
    }


    @PreDestroy
    public void preDestroy(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! CusServiceImpl preDestroy!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! CusServiceImpl postConstruct!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
