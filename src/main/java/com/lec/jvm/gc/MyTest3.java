package com.lec.jvm.gc;

/**
 * 案例三
 *
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:+PrintCommandLineFlags
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=5
 * -XX:+PrintTenuringDistribution
 *
 * JVM参数
 * -XX:MaxTenuringThreshold=5
 * 含义：在可以自动调节对象晋升（Promote）到老年代阈值的GC中，设置该阈值的最大值。
 * 该参数的默认值为15，CMS中默认值为6，G1中默认值为15（在JVM中，该数值是由4个bit来表示的，所以最大值为1111，即15。）
 * 经历了多次GC后，存活的对象会在From Survivor和To Survivor之间来回存放，
 * 而这里一个前提则是这两个空间有足够的大小来存放这些数据，在GC算法中，
 * 会计算每个对象年龄的大小，如果达到某个年龄后总大小已经大于Survivor（单个）空间的50%，
 * 那么这时候就需要调节阈值，不能再继续等到默认的15次GC后才完成晋升，
 * 因为这样会导致Survivor空间不足，所以需要调整阈值，让这些存活对象尽快完成晋升。
 *
 * -XX:+PrintTenuringDistribution
 * 输出年龄为n的对象有多少字节。。。
 *
 * -XX:+PrintCommandLineFlags
 * 含义：输出JVM命令行启动参数
 *
 */
public class MyTest3 {
    public static void main(String[] args) {
        int size = 1024 * 1024;

        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];

        /**
         * -XX:InitialHeapSize=20971520 -XX:InitialTenuringThreshold=5 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=5 -XX:NewSize=10485760 -XX:+PrintCommandLineFlags -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:SurvivorRatio=8 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
         * [GC (Allocation Failure)
         * Desired survivor size 1048576 bytes, new threshold 5 (max 5)
         * [PSYoungGen: 8175K->776K(9216K)] 8175K->6928K(19456K), 0.0065540 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
         * [Full GC (Ergonomics) [PSYoungGen: 776K->0K(9216K)] [ParOldGen: 6152K->6800K(10240K)] 6928K->6800K(19456K), [Metaspace: 3189K->3189K(1056768K)], 0.0073414 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
         * Heap
         *  PSYoungGen      total 9216K, used 2213K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 8192K, 27% used [0x00000000ff600000,0x00000000ff829778,0x00000000ffe00000)
         *   from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
         *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         *  ParOldGen       total 10240K, used 6800K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         *   object space 10240K, 66% used [0x00000000fec00000,0x00000000ff2a4230,0x00000000ff600000)
         *  Metaspace       used 3210K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 349K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
