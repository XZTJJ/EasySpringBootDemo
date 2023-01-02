package com.zhouhc.demo.config;

import com.zhouhc.demo.po.MyDate;
import com.zhouhc.demo.po.MyPoJo;
//第三方引入
//import com.zhouhc.test.ThirdPartyPOJO;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 自定义配置中心
 */
@Configuration
public class CusConfiguaration {

    //自定义Bean
    @Bean
    public MyDate getMyDate() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for MyDate!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return new MyDate(LocalDateTime.now(), 12);
    }


    @Bean
    public MyPoJo getMyPoJo() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for MyPoJo!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return new MyPoJo("txt1", "txt2");
    }


    @Bean
    public String myEnvStr(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for String!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.printf("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for MyDate is %s%n", getMyDate());
        System.out.printf("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for MyDate is %s%n", getMyDate());
        System.out.printf("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for MyPoJo is %s%n", getMyPoJo());
        System.out.printf("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Just for MyPoJo is %s%n", getMyPoJo());
        return "zhouhc-Env";
    }

    /**随便写个java工程，作为maven依赖引入或者使用jar引入，ThirdPartyPOJO就是一个第三方的Bean，真的可以注入属性
    @Bean
    @ConfigurationProperties(prefix = "third")
    public ThirdPartyPOJO thirdPartyPOJO() {
        return new ThirdPartyPOJO();
    }*/
}
