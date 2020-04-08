package com.lec.jvm.memory;

/*
    虚拟机栈溢出:java.lang.StackOverflowError
    设置虚拟机栈大小
        -Xss1m

 */
public class MyTest2 {

    private int length;

    public int getLength() {
        return length;
    }

    public void test() {
        this.length++;
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try {
            myTest2.test();
        } catch (Throwable ex) {
            System.out.println(myTest2.getLength());
            ex.printStackTrace();
        }
    }
}
