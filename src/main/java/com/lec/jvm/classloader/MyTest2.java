package com.lec.jvm.classloader;

/**
 * 《《《如果str用final修饰，那么将不会执行静态代码块》》》
 * 原因：常量在编译阶段会存入到调用这个常量方法所在的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此不会触发
 * 定义常量类的初始化。
 * 注意：这里指的是将常量str存放到了MyTest2的常量池中，
 * 之后MyTest2与MyParent2就没有任何关系了，
 * 甚至，我们可以将MyParent2的class文件删除。
 *
 * javap -c MyTest2
 * Compiled from "MyTest2.java"
 * public class com.lec.jvm.classloader.MyTest2 {
 *   public com.lec.jvm.classloader.MyTest2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #4                  // String hello world
 *        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 *
 *
 * 助记符：
 * ldc表示将int,float或String类型的常量从常量池推送至栈顶
 * bipush表示将单字节（-128 -~ 127）的常量推送至栈顶
 * sipush表示将一个短整型（-32768 ~ 32767）的常量值推送至栈顶
 * iconst_1表示将int类型的1推送至栈顶 （iconst_m1 ~ iconst_5）
 *
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
        System.out.println(MyParent2.m);
    }
}

class MyParent2 {

    public static final String str = "hello world";
    public static final short s = 127;
    public static final int i = 128;
    public static final int m = 6;

    static {
        System.out.println("MyParent2 static block");
    }
}
