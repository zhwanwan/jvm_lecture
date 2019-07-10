package com.parsing;

import java.util.StringTokenizer;

/**
 * @author zhwanwan
 * @create 2019-07-09 2:45 PM
 */
public class StringParseTest {

    public static void main(String[] args) {
        /*String phrase = "the music made   it   hard      to        concentrate";
        String delims = "[ ]+";
        String[] tokens = phrase.split(delims);
        System.out.println(Arrays.asList(tokens));*/

        String sourceString = "this is a test string";
        StringTokenizer st = new StringTokenizer(sourceString.trim());
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    private boolean isComplete(String testFilter) {

        return false;
    }
}
