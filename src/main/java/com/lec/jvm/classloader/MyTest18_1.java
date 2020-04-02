package com.lec.jvm.classloader;

/**
 * 类加载器--设置根加载器加载->将class文件拷贝到根类加载器加载的路径
 * C:\Program Files\Java\jdk1.8.0_191\jre\classes
 */
public class MyTest18_1 {

    public static void main(String[] args) throws Exception {
        //类加载器目录
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\zhwanwan\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.lec.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());

    }
}
