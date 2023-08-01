package com.zhouhc.demo.config;

import com.zhouhc.demo.po.MyPoJo;
import org.springframework.beans.BeansException;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * BeanFactoryPostProcessor 和 BeanPostProcessor 具体实现类
 */
@Configuration
public class CusBeanFactoryPostProcessorConfig {

    @Bean
    public BeanFactoryPostProcessor cusBeanFactoryPostProcessor() {
        return (beanFactory) -> {
            BeanDefinition getMyPoJo = beanFactory.getBeanDefinition("getMyPoJo");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! BeanFactoryPostProcessor 获取getMyPoJo的BeanDefinition " + getMyPoJo + " !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        };
    }

    @Bean
    public BeanPostProcessor cusBeanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof MyPoJo){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! BeanPostProcessor的postProcessBeforeInitialization MyPoJo的beanName: "+beanName+" !!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof MyPoJo){
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!! BeanPostProcessor的postProcessAfterInitialization MyPoJo的beanName: "+beanName+" !!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
                return bean;
            }
        };
    }
}
