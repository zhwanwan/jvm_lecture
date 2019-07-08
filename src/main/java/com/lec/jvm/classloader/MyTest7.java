package com.lec.jvm.classloader;

/**
 * @author zhwanwan
 * @create 2019-07-08 9:23 PM
 */
public class MyTest7 {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("com.lec.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader());

    }

}

class C {

}

