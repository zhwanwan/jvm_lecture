package com.lec.jvm.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Date;

/**
 * 虚引用PhantomReference
 */
public class MyTest4 {

    public static void main(String[] args) {

        Date date = new Date();
        ReferenceQueue<Date> referenceQueue = new ReferenceQueue<>();

        PhantomReference<Date> phantomReference = new PhantomReference<>(date, referenceQueue);

        System.out.println(phantomReference.get()); //phantomReference.get()永远返回null
    }

}
