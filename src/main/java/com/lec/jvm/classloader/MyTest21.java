package com.lec.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 命名空间：
 * 每个类加载器都有自己的命名空间，命名空间由该加载器及所有父加载器的类组成。
 * 在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类。
 * 在不同的命名空间中，有可能会出现类的完整名字（包括类的包名）相同的两个类。
 */
public class MyTest21 {

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("C:\\Users\\zhwanwan\\Desktop\\");
        loader2.setPath("C:\\Users\\zhwanwan\\Desktop\\");
        Class<?> clazz1 = loader1.loadClass("com.lec.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.lec.jvm.classloader.MyPerson");

        System.out.println(clazz1 == clazz2); //两个类加载器不同，命名空间不同

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);

    }
}
