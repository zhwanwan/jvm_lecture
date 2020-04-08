package com.lec.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/*
 * JVM内存空间：
 * 1.虚拟机栈：Stack Frame 栈帧
 * 2.程序计数器（Program Counter）
 * 3.本地方法栈：主要用于处理本地方法
 * 4.堆（Heap）：JVM管理的最大一块空间，与堆相关的一个概念是垃圾收集器。
 * 现代几乎所有的垃圾收集器都是采用分代收集算法，所以，堆空间也基于这一点进行了相应的划分：新生代与老年代。
 * Eden空间、From Survivor空间和To Survivor空间。
 * 5.方法区（Method Area）：存储元信息。永久代（Permanent Generation，
 * JDK8开始，彻底废除了永久代，使用元空间（Metaspace）代替。
 * 6.运行时常量池：方法区的一部分内容—编译期间使用。
 * 7.直接内存：Direct Memory（Netty中也叫堆外内存），并非JVM直接管理，
 * 而是与Java NIO（Selector、Channel、Buffer）密切相关。JVM通过DirectByteBuffer来操作直接内存。
 *
 * New关键字创建对象的3个步骤
 * 1.在堆内存中创建出对象的实例
 * 2.为对象的实例成员变量赋初值
 * 3.将对象的引用返回
 *
 * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 *
 *
 */
public class MyTest1 {


    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();
        for (; ; )
            list.add(new MyTest1());
    }

}
