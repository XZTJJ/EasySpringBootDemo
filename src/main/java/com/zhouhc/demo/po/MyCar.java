package com.zhouhc.demo.po;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class MyCar implements BeanFactoryAware, BeanNameAware,
        InitializingBean, DisposableBean {

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public MyCar() {
        System.out.println("MyCar构造函数已经被创建");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用了 BeanFactoryAware.setBeanFactory() 方法");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("调用了 BeanNameAware.setBeanName() 方法");
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用了 InitializingBean.afterPropertiesSet() 方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用了 DisposableBean.destroy() 方法");
    }

    //测试init方法
    public void myInit() {
        System.out.println("调用了init-method方法,将maxSpeed设置成240");
        this.maxSpeed = 240;
    }

    //测试destory方法
    public void myDestroy() {
        System.out.println("调用了destroy-method方法");
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("MyCar的属性信息,brand:" + brand + "; color:" + color +
                "; maxSpeed:" + maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
