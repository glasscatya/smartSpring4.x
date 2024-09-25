package com.smart.context;

import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean,
        DisposableBean {
    private String brand;

    private String color;

    private int maxSpeed;

    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactory set: " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("Bean name set: " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean initialized: " + beanName);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroyed: " + beanName);
    }

    //<bean>
    public void myInit() {
        System.out.println("调用init-method所指定的myInit()");
        this.maxSpeed = 240;
    }

    //<
    public void myDestroy() {
        System.out.println("调用destroy-method所指定的方法.");
    }

    //常规Bean属性.
    public Car() {
        System.out.println("Car无参构造器.");
    }

    public Car(String brand, String color, int maxSpeed) {
        System.out.println("Car有参构造器.");
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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