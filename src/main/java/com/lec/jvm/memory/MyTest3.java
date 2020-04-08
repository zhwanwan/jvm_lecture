package com.lec.jvm.memory;

/*
 * 线程死锁
 * 分析工具：jconsole/jvisualvm
 *
 名称: Thread-A
状态: java.lang.Class@214c265e上的BLOCKED, 拥有者: Thread-B
总阻止数: 1, 总等待数: 1

堆栈跟踪:
com.lec.jvm.memory.B.method(MyTest3.java:34)
com.lec.jvm.memory.A.method(MyTest3.java:25)
   - 已锁定 java.lang.Class@4617c264
com.lec.jvm.memory.MyTest3$$Lambda$1/1831932724.run(Unknown Source)
java.lang.Thread.run(Thread.java:748)
------------------------------------------------------------------------
  名称: Thread-B
状态: java.lang.Class@4617c264上的BLOCKED, 拥有者: Thread-A
总阻止数: 1, 总等待数: 1

堆栈跟踪:
com.lec.jvm.memory.A.method(MyTest3.java:22)
com.lec.jvm.memory.B.method(MyTest3.java:37)
   - 已锁定 java.lang.Class@214c265e
com.lec.jvm.memory.MyTest3$$Lambda$2/1149319664.run(Unknown Source)
java.lang.Thread.run(Thread.java:748)
------------------------------------------------------------------------

 */
public class MyTest3 {

    public static void main(String[] args) {
        new Thread(A::method, "Thread-A").start();
        new Thread(B::method, "Thread-B").start();
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class A {
    public static synchronized void method() {
        System.out.println("Method from A");
        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {
    public static synchronized void method() {
        System.out.println("Method from B");
        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
