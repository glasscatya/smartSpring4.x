package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateReflectCar {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        PrivateCar pc = new PrivateCar();
        //pc.drive(333);


        Class<?> cls = PrivateCar.class;

        PrivateCar reflectCar = (PrivateCar) cls.getConstructor().newInstance();

        Field field = cls.getDeclaredField("color");
        field.setAccessible(true);
        field.set(pc, "red");
        //pc.drive(1000);

        Method method = cls.getDeclaredMethod("drive", int.class);
        method.setAccessible(true);
        method.invoke(pc, 1000);
    }
}
