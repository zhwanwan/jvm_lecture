package com.lec.jvm.bytecode;

/**
 * 方法的静态分派
 */
public class MyTest5 {

    //方法重载是一种静态的行为，编译期就可以完全确定。

    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father(); //g1的静态类型是Grandpa,而g1的实际类型是Father
        Grandpa g2 = new Son();

        MyTest5 myTest5 = new MyTest5();
        myTest5.test(g1);
        myTest5.test(g2);
    }

}

class Grandpa {
}

class Father extends Grandpa {
}

class Son extends Father {
}