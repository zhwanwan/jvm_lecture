package com.lec.jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Date;

/*
 * ReferenceQueue
 * 设计目的在于让我们能够知道或者识别出垃圾收集器所执行的动作。
 *
 * 所谓虚引用其实可以理解为没有引用，强度最小的引用类型，并不能通过虚引用来确保它存活与否，
 * 使用虚引用最大的目的就是当虚引用指向的对象被GC所回收时我们能够收到这个通知。
 *
 */
public class MyTest2 {

    public static void main(String[] args) {
        Date date = new Date();

        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();
        SoftReference<Date> reference = new SoftReference<>(date, referenceQueue);

        Date date1 = reference.get();
        if (date1 != null)
            System.out.println("hello");
        else
            System.out.println("world");
    }

}
