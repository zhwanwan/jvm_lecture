package com.lec.jvm.classloader;

/**
 * 自定义类加载器--命名空间
 * 1.子加载器所加载的类能够访问父加载器所加载的类；
 * 2.父加载器所加载器的类无法访问到子加载器所加载的类。
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());

        System.out.println("from MyCat: " + MySample.class);
    }


}
