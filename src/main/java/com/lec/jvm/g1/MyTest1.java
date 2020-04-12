package com.lec.jvm.g1;

/**
 * G1收集器案例一
 * JVM启动参数：
 * -verbose:gc
 * -Xms10m
 * -Xmx10m
 * -XX:+UseG1GC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m
 */
public class MyTest1 {
    public static void main(String[] args) {

        int size = 1 << 20; // 1024 * 1024 即1M大小

        byte[] myAlloc1 = new byte[size];
        byte[] myAlloc2 = new byte[size];
        byte[] myAlloc3 = new byte[size];
        byte[] myAlloc4 = new byte[size];

        System.out.println("hello world");
    }

}
