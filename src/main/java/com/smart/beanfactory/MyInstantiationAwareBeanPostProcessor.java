package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    //在Bean实例化之前调用
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println(beanClass);
        if("car".equals(beanName)) {
            System.out.println("InstantiationAware BeanPostProcessor.postProcessBeforeInstantiation");
            System.out.println("这里是在实例化之前！");
        }
        //返回null 意味着继续bean初始化，也可以直接返回一个bean代替spring的初始化。
        // 提供了很高的自由度。
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("postProcessAfterInstantiation");
            System.out.println("这里在bean初始化后");
        }
        //返回true 以继续Bean生命周期。
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues,
                                                    PropertyDescriptor[] propertyDescriptors,
                                                    Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)) {
            System.out.println("postProcessPropertyValues");
            System.out.println("这里在属性注入前");
        }
        System.out.println("-------------propertyValues : " );
        Arrays.stream(propertyValues.getPropertyValues()).forEach(System.out::println);
        System.out.println("-------------propertyDescriptors[] : ");
        Arrays.stream(propertyDescriptors).forEach(System.out::println);

        return propertyValues;
    }
}
