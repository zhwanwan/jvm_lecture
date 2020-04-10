package com.lec.jvm.gc;

/**
 * JVM运行参数：
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:+UseConcMarkSweepGC -->针对老年代的，新生代还是使用默认的ParNew
 */
public class MyTest5 {
    public static void main(String[] args) {
        int size = 1 << 20;
        byte[] myAlloc1 = new byte[4 * size];
        System.out.println("111111");
        byte[] myAlloc2 = new byte[4 * size];
        System.out.println("222222");
        byte[] myAlloc3 = new byte[2 * size];
        System.out.println("333333");
        byte[] myAlloc4 = new byte[2 * size];
        System.out.println("444444");

        System.out.println("hello world");
    }
}
