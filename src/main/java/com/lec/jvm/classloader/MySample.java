package com.lec.jvm.classloader;

/**
 * @author zhwanwan
 * @create 2019-07-09 9:23 PM
 */
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("from MySample: " + MyCat.class);
    }
}
