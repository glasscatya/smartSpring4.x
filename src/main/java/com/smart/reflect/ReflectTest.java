package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Class<?> carClass = Class.forName("com.smart.reflect.Car");
        //Car car = (Car) carClass.getConstructor(String.class, String.class, Integer.TYPE)
        //                        .newInstance("xiao", "1", 1);
        Class carC = Car.class;
        carC.getDeclaredConstructor().newInstance();


        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class<?>[]) null);
        Car car = (Car) cons.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "xiaomi");
        Method getBrand = clazz.getMethod("getBrand");

        System.out.println(getBrand.invoke(car));
        return car;
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
