package com.smart.context;

import com.smart.Car;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Map;

public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext ac = new FileSystemXmlApplicationContext("F:\\CodePractice\\Java\\smart\\src\\main\\resources\\com\\smart\\beanfactory\\beans.xml");
        Map<String, BeanPostProcessor> processors = ac.getBeansOfType(BeanPostProcessor.class);
        processors.forEach((name, processor) -> System.out.println("Registered BeanPostProcessor: " + name));
        Car car = ac.getBean("car", Car.class);
        car.introduce();
    }
}
