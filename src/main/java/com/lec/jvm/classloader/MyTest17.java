package com.lec.jvm.classloader;

/**
 * @author zhwanwan
 * @create 2019-07-09 9:29 PM
 */
public class MyTest17 {

    public static void main(String[] args) throws Exception {

        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("com.lec.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        //如果注释下面一行，就不会实例化MySample对象，即MySample构造方法不会被调用
        Object object = clazz.newInstance();


    }
}
