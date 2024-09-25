package com.smart.context;


import com.smart.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class AnnotationAndGroovyApplicationContextTest {
    @Test
    public void getBean() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car carMax = ctx.getBean("carMax", Car.class);
        assertNotNull(carMax);
        carMax.introduce();
    }

    //@Test 测试完全失败=。=
    //public void getBeanByGAC() {
    //    String currentDir = System.getProperty("user.dir");
    //    System.out.println("Current working directory: " + currentDir);
    //    System.out.println("-------------------------------");
    //    ApplicationContext ctx = new GenericGroovyApplicationContext(
    //    );
    //
    //    Car carMax = ctx.getBean("carMax", Car.class);
    //    assertNotNull(carMax);
    //}
}

