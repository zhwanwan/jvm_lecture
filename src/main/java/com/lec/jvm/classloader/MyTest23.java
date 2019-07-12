package com.lec.jvm.classloader;

import sun.misc.Launcher;

/**
 * 在运行期，一个Java类由该类的完全限定名（binary name)和用于加载该类的定义类加载器（defining loader)所共同决定的。
 * 如果同样名字（即相同的完全限定名）的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文件的字节码完全一样，
 * 并且从相同的位置加载亦如此。
 *
 * 在Oracle的Hotspot实现中，系统属性sun.boot.class.path如果修改错了，则运行会出错，提示如下信息：
 * Error occurred during initialization of VM
 * java/lang/NoClassDefFoundError: java/lang/Object
 *
 * java.system.class.loader可以自定义类加载器
 * java -Djava.system.class.loader=com.lec.jvm.classloader.MyTest16 com.lec.jvm.classloader.MyTest23
 *
 *
 */
public class MyTest23 {

    public static void main(String[] args) {

        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        /**
         * 内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类，当JVM启动时，
         * 一块特殊的机器码就会运行，它会加载扩展类加载器与系统类加载器，这块特殊的机器码叫做启动类加载器（Bootstrap)。
         * 启动类加载器并不是Java类，而其他的加载器则都是Java类。
         * 启动类加载器是特定平台的机器指令，它负责开启整个加载过程。
         * 所有类加载器（除了启动类加载器）都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，
         * 从而让整个加载过程能顺利运行下去，加载第一个纯Java类加载器就是启动类加载器的职责。
         * 启动类加载器还会负责加载提供JRE正常运行所需要的组件，这报货java.util和java.lang包中的类等。
         *
         * 扩展类加载器与系统类加载器(二者在sun.misc.Launcher类中)也是由启动类加载器所加载的。
         */
        System.out.println(ClassLoader.class.getClassLoader());

        System.out.println(Launcher.class.getClassLoader());

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());
        System.out.println(MyTest16.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());


    }
}
