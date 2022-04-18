package com.yore;

import java.util.Random;

/**
 * @author Yore
 * @date 2022/3/8 9:27
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0;i<10;i++){
            int number = random.nextInt(10);
            System.out.println(number);
        }
    }
}
