package com.lec.jvm.classloader;

import java.io.*;

/**
 * 自定义ClassLoader
 */
public class MyTest16 extends ClassLoader {

    //自定义类加载器的名字
    private String classLoaderName;
    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    public Class<?> findClass(String className) {
        System.out.println("findClass invoked " + className);
        System.out.println("classloader name " + this.classLoaderName);
        byte[] b = loadClassData(className);
        return defineClass(className, b, 0, b.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        className = className.replace(".", File.separator);

        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");

            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (baos != null) baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }


    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.lec.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
//        loader1.setPath("E:\\2019\\jvm_lecture\\out\\production\\classes\\");
        loader1.setPath("C:\\Users\\zhwanwan\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.lec.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println("------------------------------------");
        MyTest16 loader2 = new MyTest16("loader2");
        loader2.setPath("C:\\Users\\zhwanwan\\Desktop\\");
        Class<?> clazz2 = loader2.loadClass("com.lec.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

    }

}
