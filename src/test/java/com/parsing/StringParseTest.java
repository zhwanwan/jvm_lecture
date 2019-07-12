package com.parsing;

import java.util.StringTokenizer;

/**
 * @author zhwanwan
 * @create 2019-07-09 2:45 PM
 */
public class StringParseTest {


    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        /*String phrase = "the music made   it   hard      to        concentrate";
        String delims = "[ ]+";
        String[] tokens = phrase.split(delims);
        System.out.println(Arrays.asList(tokens));*/

        /*String sourceString = "this is a test";
        StringTokenizer st = new StringTokenizer(sourceString.trim());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }*/
        System.out.println(MAXIMUM_CAPACITY);
        //System.out.println(tableSizeFor(16));
        int n = 15;
        n |= n >>> 1;
        System.out.println(n);
        System.out.println(15 | 7);
//        System.out.println(15>>>2);


    }

    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private boolean isComplete(String testFilter) {

        return false;
    }
}
