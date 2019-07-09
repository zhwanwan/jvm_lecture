package com.lec.jvm.classloader;

/**
 * 反射（如Class.forName("com.test.Test"))--主动使用
 * 调用ClassLoad.load()方法加载一个类，并不是对一个类的主动使用，不会导致类的初始化
 *
 * Output:
 * class com.lec.jvm.classloader.CL
 * ---------------------
 * Class CL
 * class com.lec.jvm.classloader.CL
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {

        //系统类加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("com.lec.jvm.classloader.CL");
        System.out.println(clazz);

        System.out.println("---------------------");

        clazz = Class.forName("com.lec.jvm.classloader.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}