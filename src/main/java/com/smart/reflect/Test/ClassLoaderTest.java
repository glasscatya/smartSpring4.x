package com.smart.reflect.Test;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("当前加载器: " + classLoader); //sun.misc.Launcher$AppClassLoader@
        System.out.println("父加载器: " + classLoader.getParent()); //sun.misc.Launcher$ExtClassLoader@
        System.out.println("爷爷加载器: " + classLoader.getParent().getParent()); //null
        // 根加载器 c++编写，负责载入JRE核心组件
    }
}
