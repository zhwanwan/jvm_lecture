package com.lec.jvm.memory;

/*
 * JVM分析工具
 * jcmd--JDK7新增
 * jcmd PID VM.flags：查看VM启动参数
 * jcmd PID help：列出当前运行的Java进程可以执行的操作
 * jcmd PID help <option>:查看具体命令option
 */
public class MyTest5 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("hello world");
        }
    }
}
