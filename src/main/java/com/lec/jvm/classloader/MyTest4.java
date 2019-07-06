package com.lec.jvm.classloader;

/**
 * 对于数组实例来说，器类型是有JVM在运行期动态生成的，表示为[Lcom.lec.jvm.classloader.MyParent4这种形式。
 * 动态生成的类型，其父类型就是Object.
 *
 * 对于数组来说，JavaDoc经常讲构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型。
 *
 * 助记符：
 * anewarray：表示创建一个引用类型，如类、接口、数组，并将其引用值压入栈顶；
 * newarray：表示创建一个原始类型，如int、float、char等的数组，并将其引用压入栈顶；
 */
public class MyTest4 {

    public static void main(String[] args) {
        //MyParent4静态代码块会执行
//        MyParent4 parent4 = new MyParent4();

        //MyParent4静态代码块不会执行
        MyParent4[] myParent4s = new MyParent4[3];
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("==================");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

    }

}

class MyParent4 {
    static {
        System.out.println("MyParent4 static block");
    }
}
