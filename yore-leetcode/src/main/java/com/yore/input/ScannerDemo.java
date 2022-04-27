package com.yore.input;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yore
 * @date 2022/4/27 9:46
 * @description
 */
public class ScannerDemo {

    public void intDemo() {
        Scanner sc = new Scanner(System.in);
        //可以用来判断是否结束
        while (sc.hasNextInt()) {
            String line = sc.nextLine();
            String[] numbers = line.split(" ");
            int len = numbers.length;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += Integer.valueOf(numbers[i]);
            }
            System.out.println(sum);
        }
    }

    public void strDemo() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            Arrays.sort(lines);
            for (int i = 0; i < lines.length; i++) {
                System.out.print(lines[i] + " ");
            }
            System.out.println();

        }
    }
}
