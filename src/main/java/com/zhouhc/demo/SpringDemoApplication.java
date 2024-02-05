package com.zhouhc.demo;

import com.zhouhc.demo.config.CusConfiguaration;
import com.zhouhc.demo.po.CusBeanFactoryPostProcessor;
import com.zhouhc.demo.po.MyCar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 启动加上这个参数 : -Dspring.profiles.active=dev
 */
//@SpringBootApplication
public class SpringDemoApplication {
    public static void main(String[] args) {
        // SpringApplication.run(SpringDemoApplication.class, args);
        //试试直接通过注解启动来加载
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CusConfiguaration.class);
        MyCar myCar = context.getBean(CusBeanFactoryPostProcessor.CUS_BEAN_NAME, MyCar.class);
        myCar.introduce();
        System.out.println("完成加载");
    }
}
