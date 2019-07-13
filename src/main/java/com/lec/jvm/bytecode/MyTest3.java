package com.lec.jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 字节码--异常处理
 *
 * 对于Java类中的每一个实例方法（非static方法），其在编译后生成的字节码当中，
 * 方法参数的数量总是会比源代码中方法参数的数量多一个（this），它位于方法的
 * 第一个参数位置处；这样，我们就可以在Java的实例方法中使用this来去访问当前
 * 对象的属性以及其他方法。
 * 这个操作是在编译期间完成的，即由javac编译器在编译的时候对this的访问转化
 * 为对一个普通实例方法参数的访问，接下来在运行期间，由JVM在调用实例方法时，
 * 自动向实例方法传入this参数。所以，在实例方法的局部变量中，至少有一个指向
 * 当前对象的局部变量【this】。
 *
 * Java字节码对于异常的处理方式：
 * 统一采用异常表的方式来对异常进行处理
 * 在JDK1.4.2之前的版本中，并不是使用异常表的方式来对异常进行处理的，而是采用特定的指令方式。
 * 当异常处理存在finally语句块时，现代化的JVM采取的处理方式是将finally语句块的字节码拼接到每一个catch块后面，即程序中存在多少个catch块，
 * 就会在每一个catch块后面重复多少个finally语句块。
 *
 */
public class MyTest3 {

    /**
     *   public void test();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=3, locals=4, args_size=1 --> 【args_size=1】Java中每一个实例方法中第一个参数就是this
     *          0: new           #2                  // class java/io/FileInputStream
     *          3: dup
     *          4: ldc           #3                  // String text.txt
     *          6: invokespecial #4                  // Method java/io/FileInputStream."<init>":(Ljava/lang/String;)V
     *          9: astore_1
     *         10: new           #5                  // class java/net/ServerSocket
     *         13: dup
     *         14: sipush        9999
     *         17: invokespecial #6                  // Method java/net/ServerSocket."<init>":(I)V
     *         20: astore_2
     *         21: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         24: ldc           #8                  // String finally
     *         26: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         29: goto          79
     *         32: astore_1
     *         33: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         36: ldc           #8                  // String finally
     *         38: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         41: goto          79
     *         44: astore_1
     *         45: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         48: ldc           #8                  // String finally
     *         50: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         53: goto          79
     *         56: astore_1
     *         57: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         60: ldc           #8                  // String finally
     *         62: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         65: goto          79
     *         68: astore_3
     *         69: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         72: ldc           #8                  // String finally
     *         74: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
     *         77: aload_3
     *         78: athrow
     *         79: return
     *       Exception table:
     *          from    to  target type
     *              0    21    32   Class java/io/FileNotFoundException
     *              0    21    44   Class java/io/IOException
     *              0    21    56   Class java/lang/Exception
     *              0    21    68   any
     */
    public void test() throws FileNotFoundException,IOException {

        try {

            InputStream is = new FileInputStream("text.txt");
            ServerSocket serverSocket = new ServerSocket(9999);
            serverSocket.accept();

        } catch (FileNotFoundException fe) {

        } catch (IOException ioe) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
