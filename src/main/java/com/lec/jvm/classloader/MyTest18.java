package com.lec.jvm.classloader;

/**
 * 类加载器--自带类加载器加载路径
 */
public class MyTest18 {

    public static void main(String[] args) throws Exception {
        //类加载器目录
        System.out.println("Bootstrap Class Loader:");
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("Extension Class Loader:");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("App Class Loader:");
        System.out.println(System.getProperty("java.class.path"));
    }
}
