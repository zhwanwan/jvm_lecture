package com.lec.jvm.ref;

import java.lang.ref.WeakReference;
import java.util.Date;

/*
 * 弱引用WeakReference
 *
 * 弱引用跟软引用的区别：
 * 1.如果一个对象只是弱引用可达的（既指向对象的力度最强的引用类型就是弱引用），
 * 那么该对象会在下一个垃圾收集周期中被清理掉；
 * 如果一个对象是软引用可达的，那么该对象一般来说会持续（存活）时间更久一些。
 *
 * 其实对于软、弱、虚引用的类而言，重点不是在于它的实现，而是在于它的类型，
 * 如果JVM判定了当前的类型是一个软引用则会采取软引用的特点进行对待，其他的类型则类。
 */
public class MyTest3 {

    public static void main(String[] args) {

        Date date = new Date();
        WeakReference<Date> weakReference = new WeakReference<>(date);

        System.gc();

        //休眠一些
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(weakReference.get());
    }

}
