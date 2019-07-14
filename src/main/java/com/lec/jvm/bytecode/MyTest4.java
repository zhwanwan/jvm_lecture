package com.lec.jvm.bytecode;

/**
 *  栈帧（stack frame)
 *
 *  栈帧是一种用于帮助虚拟机执行方法调用与方法执行的数据结构。
 *
 *  栈帧本身是一种数据结构，封装了方法的局部变量表、动态链接信息、方法的返回地址以及操作数栈等信息。
 *
 *  分符号引用和直接引用：
 * 有些符号引用是在类加载阶段或是第一次使用的时候就会转换为直接引用，这种转换叫做静态解析；
 * 另外一些符号引用则是在每次运行期转换为直接引用，这种转换叫做动态链接，这体现为Java的多态行。
 *
 * 方法调用的5种指令
 * invokeinterface：调用接口中的方法，实际上是在运行期决定的，决定到底调用实现该接口哪个对象的特定方法。
 * invokestatic：调用静态方法。
 * invokespecial：调用自己的私有方法、构造方法（<init>）以及父类的方法。
 * invokevirtual：调用虚方法（跟多态相关，运行期动态查找）。
 * invokedynamic：动态调用方法（JDK1.7引入，如可以调用JavaScript）。
 *
 * 静态解析的4种情景
 * 静态方法
 * 父类方法
 * 构造方法
 * 私有方法
 * 以上4类方法称作非虚方法，它们是在类加载阶段就可以将符号引用转换为直接引用。
 *
 */
public class MyTest4 {

    public static void test() {
        System.out.println("test invoked");
    }

    /**
     * 0 invokestatic #5 <com/lec/jvm/bytecode/MyTest4.test>
     * 3 return
     *
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

}
