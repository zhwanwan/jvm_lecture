package com.lec.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理的客户端
 */
public class Client {

    public static void main(String[] args) {

        //设置属性来生成动态代理类--com.sun.proxy.$Proxy0.class
        //ProxyGenerator-->saveGeneratedFiles
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject rs = new RelSubject();

        InvocationHandler ds = new DynamicSubject(rs);

        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);

        System.out.println(subject.getClass()); //class com.sun.proxy.$Proxy0
        System.out.println(subject.getClass().getSuperclass()); //class java.lang.reflect.Proxy

        subject.request();
    }

}
