package com.lec.jvm.classloader;

/**
 * 类加载器
 */
public class MyTest7 {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.lec.jvm.classloader.MT7");
        System.out.println(clazz2.getClassLoader());

    }

}

class MT7 {

}

