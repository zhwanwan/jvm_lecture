package com.lec.jvm.gc;

/**
 * 案例二
 * 查看JVM启动默认参数：
 * java -XX:PrintCommandLineFlags –version
 * -XX:InitialHeapSize=265502720 -XX:MaxHeapSize=4248043520 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
 * java version "1.8.0_241"
 * Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
 * Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
 * 启动参数
 * -XX:PretenureSizeThreshold=4194304 （4M 字节）
 * 含义：如果要创建对象的大小超过这个预值，该对象就不会在新生代分配，而直接进入老年代
 * 该参数需要在Serial GC下才生效，设置参数-XX:+UseSerialGC
 *
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=4194304
 * -XX:+UseSerialGC
 *
 */
public class MyTest2 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] myAlloc5 = new byte[5 * size];
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
