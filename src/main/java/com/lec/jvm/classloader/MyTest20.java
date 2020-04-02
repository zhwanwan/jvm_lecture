package com.lec.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 类加载器--示例
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");

        Class<?> clazz1 = loader1.loadClass("com.lec.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.lec.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2); //二者都是由应用加载器加载的*****

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
