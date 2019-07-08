package com.lec.jvm.classloader;

import java.util.Random;

/**
 * @author zhwanwan
 * @create 2019-07-08 9:38 PM
 */
public class MyTest8 {

    public static void main(String[] args) {
        System.out.println(FinalTest.x);
    }
}

class FinalTest {
    public static final int x = new Random().nextInt(3);
    static {
        System.out.println("FinalTest static block");
    }
}