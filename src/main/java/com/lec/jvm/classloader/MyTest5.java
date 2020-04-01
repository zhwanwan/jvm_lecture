package com.lec.jvm.classloader;

/**
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化；
 * 只有在真正使用到父接口的时候，如引用接口中所定义的常量，才会初始化。
 */
public class MyTest5 {
    public static void main(String[] args) {

        //System.out.println(MyChild5.b);
        //new C();
        System.out.println(MyParent5_1.thread);

    }
}

class MyGrandpa {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandpa invoked");
        }
    };
}

class MyParent5 extends MyGrandpa {
    //    int a = new Random().nextInt(3);
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5 invoked");
        }
    };
}

/**
 * class MyChild5 implements MyParent5 {
 * public static int b = 5;
 * }
 * 这种情况下，会加载MyParent5和MyChild5
 * [Loaded com.lec.jvm.classloader.MyTest5 from file:/E:/2019/jvm_lecture/out/production/classes/]
 * [Loaded com.lec.jvm.classloader.MyParent5 from file:/E:/2019/jvm_lecture/out/production/classes/]
 * [Loaded com.lec.jvm.classloader.MyChild5 from file:/E:/2019/jvm_lecture/out/production/classes/]
 * <p>
 * -------------------------------------------
 * <p>
 * interface MyChild5 extends MyParent5 {
 * int b = 5;
 * }
 * 这种情况下，不会加载MyParent5和MyChild5，因为接口里，b其实是public static final的常量，直接存入MyTest5的常量池里
 * [Loaded com.lec.jvm.classloader.MyTest5 from file:/E:/2019/jvm_lecture/out/production/classes/]
 */
class MyChild5 extends MyParent5 {
    public static final int b = 5;
}

/**
 * 先执行代码块--顺序执行，再执行构造方法
 */
class C {

    public C() {
        System.out.println("C");
    }

    {
        System.out.println("Hello1");
    }

    {
        System.out.println("Hello2");
    }
}

interface MyGrandpa5_1 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandpa5_1 invoked");
        }
    };
}

interface MyParent5_1 extends MyGrandpa5_1 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 invoked");
        }
    };
}