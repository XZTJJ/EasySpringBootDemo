package com.zhouhc.demo.po;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.*;

import java.util.Objects;


public class CusBeanFactoryPostProcessor {

    public static final String CUS_BEAN_NAME = "getMycar";


    //自定义的BeanFactoryPostProcessor
    public static class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(CUS_BEAN_NAME);
            System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()方法获取BeanDefinition," + CUS_BEAN_NAME +
                    "相关信息, 工厂类为: " + beanDefinition.getFactoryBeanName() + ",父类为: " + beanDefinition.getParentName() + "" +
                    ",描述信息为：" + beanDefinition.getDescription());

        }
    }


    //自定义的InstantiationAwareBeanPostProcessor类
    public static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (Objects.equals(CUS_BEAN_NAME, beanName)) {
                System.out.println("MyInstantiationAwareBeanPostProcessor 的 postProcessBeforeInstantiation() 被调用");
            }
            return null;
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (Objects.equals(CUS_BEAN_NAME, beanName)) {
                System.out.println("MyInstantiationAwareBeanPostProcessor 的 postProcessAfterInstantiation() 被调用");
            }
            return true;
        }

        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            if (Objects.equals(CUS_BEAN_NAME, beanName)) {
                System.out.println("MyInstantiationAwareBeanPostProcessor 的 postProcessProperties() 被调用");
            }
            return pvs;
        }
    }


    //自定义的BeanPostProcessor类
    public static class MyBeanPostProcessor implements BeanPostProcessor {

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            if (Objects.equals(CUS_BEAN_NAME, beanName)) {
                MyCar car = (MyCar) bean;
                if (Objects.isNull(car.getColor())) {
                    System.out.println("调用MyBeanPostProcessor.postProcessBeforeInitialization()，将color设置成黑色");
                    car.setColor("黑色");
                }
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            if (Objects.equals(CUS_BEAN_NAME, beanName)) {
                MyCar car = (MyCar) bean;
                if (car.getMaxSpeed() >= 200) {
                    System.out.println("调用MyBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed设置成最高为200");
                    car.setMaxSpeed(200);
                }
            }
            return bean;
        }
    }


}
