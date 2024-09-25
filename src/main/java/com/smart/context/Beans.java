package com.smart.context;

import com.smart.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean(name = "carMax")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("战斗机形态🚗");
        car.setColor("蓝白相间");
        car.setMaxSpeed(200000);
        return car;
    }
}
