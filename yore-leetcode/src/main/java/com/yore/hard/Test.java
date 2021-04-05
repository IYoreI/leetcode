package com.yore.hard;

import java.util.regex.Matcher;

/**
 * @author yore
 * @date 2021/3/28 10:03
 * @description
 */
public class Test {
    public static void main(String[] arg ) {
        String s = "bbabbab";
        String q = ".*bab";
        System.out.println(s.matches(q));
    }
}
