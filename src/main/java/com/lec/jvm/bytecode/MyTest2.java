package com.lec.jvm.bytecode;

/**
 * javap -p -verbose MyTest2
 * -p:显示private方法
 */
public class MyTest2 {
    String str = "welcome";
    private int x = 5;

    public static Integer i = 10;

    //private Object object = new Object();

    public MyTest2() {

    }

    public MyTest2(int i) {
        System.out.println(i);
    }

    /**
     *   private static synchronized void test2();
     *     descriptor: ()V
     *     flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=0, locals=0, args_size=0
     *          0: return
     *       LineNumberTable:
     *         line 89: 0
     * @param x
     */
    private synchronized void setX(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.setX(8);
        i = 20;
    }

    /**
     * private void test(java.lang.String);
     * descriptor: (Ljava/lang/String;)V
     * flags: ACC_PRIVATE
     * Code:
     * stack=2, locals=4, args_size=2
     * 0: aload_1
     * 1: dup
     * 2: astore_2
     * 3: monitorenter
     * 4: getstatic     #10                 // Field java/lang/System.out:Ljava/io/PrintStream;
     * 7: ldc           #11                 // String hello world
     * 9: invokevirtual #12                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     * 12: aload_2
     * 13: monitorexit
     * 14: goto          22
     * 17: astore_3
     * 18: aload_2
     * 19: monitorexit
     * 20: aload_3
     * 21: athrow
     * 22: return
     * Exception table:
     * from    to  target type
     * 4    14    17   any
     * 17    20    17   any
     * LineNumberTable:
     * line 25: 0
     * line 26: 4
     * line 27: 12
     * line 28: 22
     * LocalVariableTable:
     * Start  Length  Slot  Name   Signature
     * 0      23     0  this   Lcom/lec/jvm/bytecode/MyTest2;
     * 0      23     1   str   Ljava/lang/String;
     *
     * @param str
     */
    private void test(String str) {
        synchronized (str) {
            System.out.println("hello world");
        }
    }

    /**
     * 反编译：
     * private static synchronized void test2();
     * descriptor: ()V
     * flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNCHRONIZED
     * Code:
     * stack=0, locals=0, args_size=0
     * 0: return
     * LineNumberTable:
     * line 70: 0
     */
    private synchronized static void test2() {

    }

    static {
        System.out.println("test");
    }

}
