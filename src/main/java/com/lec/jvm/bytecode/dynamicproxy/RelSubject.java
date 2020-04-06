package com.lec.jvm.bytecode.dynamicproxy;

/**
 * 实际目标对象
 */
public class RelSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
