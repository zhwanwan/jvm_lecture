package com.lec.jvm.classloader;

/**
 * @author zhwanwan
 * @create 2019-07-09 9:22 PM
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
    }



}
