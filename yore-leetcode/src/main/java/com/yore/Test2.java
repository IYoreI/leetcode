package com.yore;

/**
 * @author Yore
 * @date 2022/5/20 10:16
 * @description
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(test1());
    }

    public static int test1() {
        int x = 1;
        try {
            return x;
        } catch (Exception e) {
            x = 3;
        } finally {
            x = 2;
            return x;
        }
    }
}
