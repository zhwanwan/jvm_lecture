package com.lec.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * jar hell诊断
 */
public class MyTest28 {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String resourceName = "java/lang/String.class";
        try {
            Enumeration<URL> urls = classLoader.getResources(resourceName);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                System.out.println(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
