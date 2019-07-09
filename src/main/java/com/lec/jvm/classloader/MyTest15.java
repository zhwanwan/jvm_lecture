package com.lec.jvm.classloader;

/**
 * Class objects for array classes are not created by class loaders, but are created automatically as required by the Java runtime.
 * The class loader for an array class, as returned by Class.getClassLoader() is the same as the class loader for its element type;
 * if the element type is a primitive type, then the array class has no class loader.
 *
 * 数组类是JVM在运行时自动生成。
 * 数组类的类加载器跟其数组元素的类加载器是一样的；对于原生类型，数组类不存在类加载器。
 */
public class MyTest15 {

    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("------------");
        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("---------------");
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());
    }
}
