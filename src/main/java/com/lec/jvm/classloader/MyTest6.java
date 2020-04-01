package com.lec.jvm.classloader;

/**
 * 先去准备阶段，准备阶段赋默认值，准备完成后就可以初始化--从上向下初始化
 */
public class MyTest6 {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }

}

class Singleton {

    public static int counter1;

    private static Singleton singleton = new Singleton();

    private Singleton() {
        counter1++;
        counter2++; //准备阶段
        System.out.println("inner counter1: " + Singleton.counter1);
        System.out.println("inner counter2: " + Singleton.counter2);
    }

    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}
