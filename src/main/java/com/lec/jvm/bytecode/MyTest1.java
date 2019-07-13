package com.lec.jvm.bytecode;

/** 字节码
 * $ javap com.lec.jvm.bytecode.MyTest1
 * Compiled from "MyTest1.java"
 * public class com.lec.jvm.bytecode.MyTest1 {
 *   public com.lec.jvm.bytecode.MyTest1();
 *   public int getA();
 *   public void setA(int);
 * }
 *
 * ----------------------------------------------------------------------------------------
 * $ javap -c com.lec.jvm.bytecode.MyTest1
 * Compiled from "MyTest1.java"
 * public class com.lec.jvm.bytecode.MyTest1 {
 *   public com.lec.jvm.bytecode.MyTest1();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: aload_0
 *        5: iconst_1
 *        6: putfield      #2                  // Field a:I
 *        9: return
 *
 *   public int getA();
 *     Code:
 *        0: aload_0
 *        1: getfield      #2                  // Field a:I
 *        4: ireturn
 *
 *   public void setA(int);
 *     Code:
 *        0: aload_0
 *        1: iload_1
 *        2: putfield      #2                  // Field a:I
 *        5: return
 * }
 *
 * ----------------------------------------------------------------------------------------
 *$ javap -verbose com.lec.jvm.bytecode.MyTest1
 * Classfile /E:/2019/jvm_lecture/out/production/classes/com/lec/jvm/bytecode/MyTest1.class
 *   Last modified Jul 12, 2019; size 487 bytes
 *   MD5 checksum 64849d4c062b8d94b416fff38ea9fc1b
 *   Compiled from "MyTest1.java"
 * public class com.lec.jvm.bytecode.MyTest1
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #3.#21         // com/lec/jvm/bytecode/MyTest1.a:I
 *    #3 = Class              #22            // com/lec/jvm/bytecode/MyTest1
 *    #4 = Class              #23            // java/lang/Object
 *    #5 = Utf8               a
 *    #6 = Utf8               I
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Lcom/lec/jvm/bytecode/MyTest1;
 *   #14 = Utf8               getA
 *   #15 = Utf8               ()I
 *   #16 = Utf8               setA
 *   #17 = Utf8               (I)V
 *   #18 = Utf8               SourceFile
 *   #19 = Utf8               MyTest1.java
 *   #20 = NameAndType        #7:#8          // "<init>":()V
 *   #21 = NameAndType        #5:#6          // a:I
 *   #22 = Utf8               com/lec/jvm/bytecode/MyTest1
 *   #23 = Utf8               java/lang/Object
 * {
 *   public com.lec.jvm.bytecode.MyTest1();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: iconst_1
 *          6: putfield      #2                  // Field a:I
 *          9: return
 *       LineNumberTable:
 *         line 6: 0
 *         line 8: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Lcom/lec/jvm/bytecode/MyTest1;
 *
 *   public int getA();
 *     descriptor: ()I
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #2                  // Field a:I
 *          4: ireturn
 *       LineNumberTable:
 *         line 11: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lcom/lec/jvm/bytecode/MyTest1;
 *
 *   public void setA(int);
 *     descriptor: (I)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: iload_1
 *          2: putfield      #2                  // Field a:I
 *          5: return
 *       LineNumberTable:
 *         line 15: 0
 *         line 16: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lcom/lec/jvm/bytecode/MyTest1;
 *             0       6     1     a   I
 * }
 * SourceFile: "MyTest1.java"
 * ----------------------------------------------------------------------------------------
 */
public class MyTest1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
