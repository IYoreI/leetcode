package com.yore.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Yore
 * @date 2022/5/25 16:44
 * @description
 */
public class Guanglianda20220525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            times[index++][0] = sc.nextInt();
        }
        index = 0;
        for (int i = 0; i < n; i++) {
            times[index++][1] = sc.nextInt();
        }
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int pre = times[0][1];
        for (int i = 1; i < n; i++) {
            if (times[i][0] > pre) {
                pre = times[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
