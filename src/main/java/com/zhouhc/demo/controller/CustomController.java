package com.zhouhc.demo.controller;

import com.zhouhc.demo.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//自定义配置中心
@RestController
@RequestMapping("/cus")
public class CustomController {

    @Autowired
    private CusService cusService;

    @GetMapping("/str")
    public String getCusStr(){
        return cusService.invoke();
    }
}
