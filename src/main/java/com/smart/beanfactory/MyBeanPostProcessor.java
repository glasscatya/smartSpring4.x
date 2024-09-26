package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//属性注入后调用
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")) {
            Car car = (Car) bean;
            if(car.getColor() == null) {
                System.out.println("调用postProcessBeforeInitialization，如果color为null，设置为黑色");
                car.setColor("黑色，而且是五彩斑斓的黑");
            }
        }
        //这里返回bean
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")) {
            Car car = (Car) bean;
            if(car.getMaxSpeed() < 200) {
                System.out.println("调用postProcessAfterInitialization,车速小于200的太慢了");
                System.out.println("调用发生在init-method后");
                car.setMaxSpeed(3000);
            }
        }
        return bean;
    }
}
