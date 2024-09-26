package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory() {
        //获取到xml 并使用XmlBeanReader加载Bean
        Resource resource = new ClassPathResource("com/smart/beanfactory/beans.xml");

        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        reader.loadBeanDefinitions(resource);
        //向容器内注册BeanPostProcessor
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //注册InstantiationAwareBeanPostProcessor，请注意注册顺序与调用顺序无关，请实现Ordered或@Order(1)注解。
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        //第一次从容器中获取car，触发容器实例化该Bean，Bean的生命周期方法会被逐步调用。
        Car car1 = bf.getBean("car", Car.class);
        car1.introduce();
        car1.setColor("红色");
        //第二次获取car，将会从缓存池中加载。
        Car car2 = bf.getBean("car", Car.class);

        //对比两个car是同一个吗？ 以验证单例模式
        System.out.println("car1 == car2 ? " + (car1 == car2));
        //销毁容器中的所有单例
        ((DefaultListableBeanFactory)bf).destroySingletons();
    }

    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }
}
