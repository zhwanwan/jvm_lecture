package com.lec.jvm.classloader;

/**
 * @author zhwanwan
 * @create 2019-07-10 8:25 AM
 */
public class MyTest18 {

    public static void main(String[] args) throws Exception {
        //类加载器目录
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\zhwanwan\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.lec.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());

    }
}
