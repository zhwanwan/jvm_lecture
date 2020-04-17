package com.lec.jvm.ref;

import java.lang.ref.SoftReference;
import java.util.Date;

/*
 * 强应用：
 * 1.我们日常开发中所遇到的绝大多数引用均是强引用。
 * 2.如果对象拥有强引用，就表示它是可达的，那么垃圾收集器就不会将其回收。
 * 3.如果将某个强引用显示置 为null，就表示该引用不再指向对象，若该对象没有其他引用指向它，那么在适当时机就会被垃圾收集器回收。
 *    ArrayList中clear方法能体现强引用。
 *
 * 强引用（绝大多数）
 * 软引用（Soft Reference）
 * 弱引用（Weak Reference）
 * 虚引用（Phantom Reference）
 * Reference实例的4中状态：Active、Pending、Enqueued、Inactive
 * Active：新创建的实例都会处于Active状态；
 * Pending：未被注册到引用队列中的引用对象不可能处于该状态之下；
 * Enqueued：未被注册到引用队列中的引用对象不可能处于该状态之下；
 * Inactive：无法对该状态的引用对象执行任何操作，处于该状态下的对象状态不会再发生任何变化。
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        Date date = new Date(); //强引用
        SoftReference<Date> reference = new SoftReference<>(date); //软引用
        reference.clear();
        Date date1 = reference.get();
        if (null != date1)
            System.out.println("hello");
        else
            System.out.println("world");
    }

}
