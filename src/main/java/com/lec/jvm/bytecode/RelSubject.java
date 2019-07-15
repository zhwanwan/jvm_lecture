package com.lec.jvm.bytecode;

/**
 * @author zhwanwan
 * @create 2019-07-15 7:00 PM
 */
public class RelSubject implements Subject {

    @Override
    public void request() {
        System.out.println("From real subject");
    }
}
