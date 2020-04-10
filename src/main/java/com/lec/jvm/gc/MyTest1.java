package com.lec.jvm.gc;

/**
 * 案例一
 * JVM参数介绍
 * -verbose:gc 输出详细GC信息
 * -Xms20M 堆空间初始值
 * -Xmx20M 堆空间最大值
 * -Xmn10M 堆中新生代大小
 * -XX:+PrintGCDetails 打印垃圾回收详细信息
 * -XX:SurvivorRatio=8  (Eden/Survivor=8)
 *
 *
 */
public class MyTest1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        /**
         * 实验一
         * [GC (Allocation Failure) [PSYoungGen: 5960K->792K(9216K)] 5960K->4896K(19456K), 0.0035268 secs] [Times: user=0.03 sys=0.02, real=0.00 secs]
         * hello world
         * Heap
         *  PSYoungGen      total 9216K, used 4187K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 8192K, 41% used [0x00000000ff600000,0x00000000ff950e38,0x00000000ffe00000)
         *   from space 1024K, 77% used [0x00000000ffe00000,0x00000000ffec6010,0x00000000fff00000)
         *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         *  ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         *   object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         *  Metaspace       used 3042K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 330K, capacity 388K, committed 512K, reserved 1048576K
         *
         *  [PSYoungGen: 5960K->792K(9216K)]
         *  箭头左边的5960K表示执行GC前新生代存活的对象所占据的空间
         *  箭头右边的792K表示执行GC后新生代存活的对象所占据的空间
         *  右边括号（9216K）表示新生代总空间
         *      9126K=9M，新生代总大小10M，其中Eden：Survivor（2个,From/To）= 8:1:1,其中To Survivor仅在GC回收后存放对象
         *      5960K->4896K(19456K)
         *  箭头左边5960K表示执行GC前堆空间大小
         *  箭头右边4896K表示执行GC后堆空间存活对象大小
         *  括号（19456K）表示总的堆的可用空间
         *      19456K=19M,新生代中1M（1个Survivor）“浪费”
         * 0.0035268 secs： GC耗时
         *
         * 5960-792=5168 //执行完GC后，新生代释放的空间容量
         * 5960-4896=1064 //执行GC后，总的堆空间释放容量
         * 5168-1064=4104 //新生代晋升到老年代的容量
         *
         * PSYoungGen：Parallel Scavenge （新生代垃圾收集器） --JDK8默认
         * ParOldGen： : Parallel Old （老年代垃圾收集器） --JDK8默认
         *
         *
         *
         *
         *
         */
        /*byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];*/

        /**
         * 实验二
         * [GC (Allocation Failure) [PSYoungGen: 8176K->760K(9216K)] 8176K->6912K(19456K), 0.0049685 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (Ergonomics) [PSYoungGen: 760K->0K(9216K)] [ParOldGen: 6152K->6797K(10240K)] 6912K->6797K(19456K), [Metaspace: 3155K->3155K(1056768K)], 0.0076164 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
         * hello world
         * Heap
         *  PSYoungGen      total 9216K, used 2372K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 8192K, 28% used [0x00000000ff600000,0x00000000ff8512f0,0x00000000ffe00000)
         *   from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
         *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         *  ParOldGen       total 10240K, used 6797K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         *   object space 10240K, 66% used [0x00000000fec00000,0x00000000ff2a3790,0x00000000ff600000)
         *  Metaspace       used 3188K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 345K, capacity 388K, committed 512K, reserved 1048576K
         *
         */
        /*byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];*/

        /**
         * 实验三
         * [GC (Allocation Failure) [PSYoungGen: 6128K->824K(9216K)] 6128K->4928K(19456K), 0.0034698 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * hello world
         * Heap
         *  PSYoungGen      total 9216K, used 7207K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 8192K, 77% used [0x00000000ff600000,0x00000000ffc3bdf8,0x00000000ffe00000)
         *   from space 1024K, 80% used [0x00000000ffe00000,0x00000000ffece030,0x00000000fff00000)
         *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         *  ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         *   object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         *  Metaspace       used 3210K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 349K, capacity 388K, committed 512K, reserved 1048576K
         *
         */
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[3 * size];

        System.out.println("hello world");

    }

}
