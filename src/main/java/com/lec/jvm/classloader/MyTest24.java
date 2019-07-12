package com.lec.jvm.classloader;

/**
 * 线程上下文类加载器（Context ClassLoader）
 * Thread.currentThread().getContextClassLoader()
 * Thread.currentThread().setContextClassLoader(ClassLoader)
 * 如果没有通过setContextClassLoader（cl)设置上下文类加载器，线程将继承父线程的上下文类加载器。
 * Java应用运行时的初始线程的上下文类加载器是系统类加载器；在线程中运行的代码可以通过这个类加载器来加载类与资源。
 *
 * 线程上下文类加载器的重要性：
 * SPI（Service Provider Interface）
 * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassloader()所指定的ClassLoader来加载类。
 * 这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的ClassLoader加载类的情况，即改变了双亲委托机制。
 * 线程上下文类加载器就是当前线程的Current ClassLoader。
 * 在双亲委托模型下，类加载是由下至上的，即下层的类加载器是委托上层进行加载的。
 * 但是对于SPI来说，有些接口是由Java核心库所提供的，而Java核心库是由启动类加载来加载的，
 * 而这些接口的实现却来自于不同的jar包（厂商提供，如JDBC），Java的启动类加载器是不会加载其他来源的jar包，
 * 这样传统的双亲委托模型就无法满足SPI的要求。而通过给当前线程设置上下文类加载器，
 * 就可以由设置的上下文类加载器来完成对于接口实现类的加载。
 */
public class MyTest24 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader()); //Thread是JDK核心类，由根类加载器加载

    }
}
