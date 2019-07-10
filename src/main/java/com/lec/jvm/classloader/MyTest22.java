package com.lec.jvm.classloader;

/**
 * 扩展类加载器
 * ZHWANWAN-LAP+zhwanwan@ZHWANWAN-LAP MINGW64 /e/2019/jvm_lecture/out/production/classes (master)
 * $ java -Djava.ext.dirs=. com.lec.jvm.classloader.MyTest22
 * MyTest22 initializer
 * sun.misc.Launcher$AppClassLoader@73d16e93
 * sun.misc.Launcher$AppClassLoader@73d16e93
 *
 * //将MyTest1.class打包
 * $ jar cvf test.jar com/lec/jvm/classloader/MyTest1.class
 *
 * $ java -Djava.ext.dirs=. com.lec.jvm.classloader.MyTest22
 * MyTest22 initializer
 * .
 * sun.misc.Launcher$AppClassLoader@2a139a55
 * sun.misc.Launcher$ExtClassLoader@33909752
 *
 */
public class MyTest22 {
    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
    }
}
