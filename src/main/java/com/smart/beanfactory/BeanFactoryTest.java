package com.smart.beanfactory;

import static org.testng.Assert.*;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import com.smart.reflect.*;
import org.testng.annotations.Test;

public class BeanFactoryTest {
    @Test
    public void getBean() throws Throwable {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");

        System.out.println(res.getURL());
        //spring核心类，用于获取Bean工厂实例
        DefaultListableBeanFactory facory = new DefaultListableBeanFactory();
        //用于指定读取xml类型的Bean定义文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(facory);
        //将xml文件中的bean交给Bean工厂实例
        reader.loadBeanDefinitions(res);

        System.out.println("init BeanFactory.");
        //从工厂实例中获取Bean
        Car car = facory.getBean("car1", Car.class);
        System.out.println("car Bean");
        car.introduce();

    }
}
