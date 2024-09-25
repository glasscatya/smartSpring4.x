package com.smart.reflect;

public class PrivateCar {
    private String color;

    private void drive(int speed) {
        System.out.println("正在用私有方法，驾驶" + color + "色车，以" + speed + "的速度.");
    }
}
