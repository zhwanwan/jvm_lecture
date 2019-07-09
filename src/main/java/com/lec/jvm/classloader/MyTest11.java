package com.lec.jvm.classloader;

/**
 * 谁拥有的静态变量就表示对谁的主动使用
 * 本例main方法中其实是对Parent3的主动使用
 * --------------------------------------
 *  静态方法定义在哪个类中就是对这个类的主动使用
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("------------------------");
        Child3.doSomething();
    }
}

class Parent3 {
    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}