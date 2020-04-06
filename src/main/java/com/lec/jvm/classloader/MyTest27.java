package com.lec.jvm.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
public class MyTest27 {

    public static void main(String[] args) throws Exception {

        //System.out.println(System.getProperty("jdbc.drivers"));

        Class.forName("com.mysql.jdbc.Driver"); //由于使用ServiceLoader机制，这行写不写都一样
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampdb", "root", "root");
        System.out.println(connection);

    }

}
