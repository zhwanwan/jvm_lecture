package com.lec.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * 输出：
 * file:/E:/2019/jvm_lecture/out/production/classes/com/lec/jvm/classloader/MyTest13.class
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resource = "com/lec/jvm/classloader/MyTest13.class";
        Enumeration<URL> urls = classLoader.getResources(resource);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("-----------------------------");
        Class<?> clazz = MyTest14.class;
        System.out.println(clazz.getClassLoader());
    }
}
