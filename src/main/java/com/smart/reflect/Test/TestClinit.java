package com.smart.reflect.Test;

//测试JVM加载类的过程
public class TestClinit {

    static {
        s = 1000;
    }

    private static int s = 10;

    public static void main(String[] args) {
        System.out.println("111");
    }
}
