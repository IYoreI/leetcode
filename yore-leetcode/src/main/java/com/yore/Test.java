package com.yore;

/**
 * @author Yore
 * @date 2022/3/8 9:27
 * @description
 */
public class Test {
    private static int count = 0;

    public static void main(String[] args) {
        try {
//            count++;
            System.out.println(count++);
            main(args);
        } catch (Throwable t) {
           main(args);
        }

    }
}
