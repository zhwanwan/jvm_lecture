package com.lec.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * 好处：在真实对象尚未存在时，我们就可以把代理对象创建处理
 */
public class DynamicSubject implements InvocationHandler {

    private Object sub; //代理的对象

    public DynamicSubject(Object obj) {
        this.sub = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before calling: " + method);

        method.invoke(this.sub, args);

        System.out.println("after calling: " + method);

        return null;
    }
}
