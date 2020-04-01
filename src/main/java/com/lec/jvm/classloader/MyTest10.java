package com.lec.jvm.classloader;

/**
 * 主动使用情况
 * 仅仅声明一个类的引用，不是主动使用
 */
public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2; //不会导致parent2主动使用
        System.out.println("------------------");
        parent2 = new Parent2();
        System.out.println("------------------");
        System.out.println(parent2.a);
        System.out.println("------------------");
        System.out.println(Child2.b);
    }

}

class Parent2 {
    static int a = 3;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;

    static {
        System.out.println("Child2 static block");
    }
}