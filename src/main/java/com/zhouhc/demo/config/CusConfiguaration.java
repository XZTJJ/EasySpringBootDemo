package com.zhouhc.demo.config;

import com.zhouhc.demo.po.CusBeanFactoryPostProcessor;
import com.zhouhc.demo.po.MyCar;
import com.zhouhc.demo.po.MyPoJo;
//第三方引入
//import com.zhouhc.test.ThirdPartyPOJO;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置中心
 */
@Configuration
public class CusConfiguaration {

    @Bean
    public MyPoJo getMyPoJo() {
        MyPoJo myPoJo = new MyPoJo("txt1", "txt2");
        System.out.printf("调用Configuration中的getMyPoJo()创建MyPoJo: %s%n", myPoJo);
        return myPoJo;
    }


    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    @ConfigurationProperties(prefix = "mycar")
    public MyCar getMycar() {
        MyCar myCar = new MyCar();
        System.out.printf("调用Configuration中的getMycar()创建MyCar(带有对应的init和destory方法): %s%n", myCar);
        return myCar;
    }

    @Bean
    public BeanFactoryPostProcessor getMyBeanFactoryPostProcessor() {
        CusBeanFactoryPostProcessor.MyBeanFactoryPostProcessor myBeanFactoryPostProcessor = new CusBeanFactoryPostProcessor.MyBeanFactoryPostProcessor();
        System.out.printf("调用Configuration中的getMyBeanFactoryPostProcessor()创建MyBeanFactoryPostProcessor: %s%n", myBeanFactoryPostProcessor);
        return myBeanFactoryPostProcessor;
    }


    @Bean
    public InstantiationAwareBeanPostProcessor getMyInstantiationAwareBeanPostProcessor() {
        CusBeanFactoryPostProcessor.MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor
                = new CusBeanFactoryPostProcessor.MyInstantiationAwareBeanPostProcessor();
        System.out.printf("调用Configuration中的getMyInstantiationAwareBeanPostProcessor()创建myInstantiationAwareBeanPostProcessor: %s%n", myInstantiationAwareBeanPostProcessor);
        return myInstantiationAwareBeanPostProcessor;
    }

    @Bean
    public BeanPostProcessor getMyBeanPostProcessor() {
        CusBeanFactoryPostProcessor.MyBeanPostProcessor myBeanPostProcessor = new CusBeanFactoryPostProcessor.MyBeanPostProcessor();
        System.out.printf("调用Configuration中的getMyBeanPostProcessor()创建myBeanPostProcessor: %s%n", myBeanPostProcessor);
        return myBeanPostProcessor;
    }

    /**随便写个java工程，作为maven依赖引入或者使用jar引入，ThirdPartyPOJO就是一个第三方的Bean，真的可以注入属性
     @Bean
     @ConfigurationProperties(prefix = "third")
     public ThirdPartyPOJO thirdPartyPOJO() {
     return new ThirdPartyPOJO();
     }*/
}
