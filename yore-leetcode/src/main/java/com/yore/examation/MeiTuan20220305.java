package com.yore.examation;

import java.util.Scanner;

/**
 * @author Yore
 * @date 2022/3/6 9:41
 * @description
 */
public class MeiTuan20220305 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int index = 0;
        while (index < 6) {
            nums[index++] = in.nextInt();
        }
        System.out.println(process(nums));
    }


    public static int process(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] memory = new int[n];
        leftMax[0] = nums[0];
        memory[0] = nums[0];
        rightMax[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1] + nums[i], nums[i]);
            memory[i] = Math.max(leftMax[i], memory[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1] + nums[i], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int j = n - 1; j > 0; j--) {
            max = Math.max(max, rightMax[j] + memory[j - 1]);
        }
        return max;
    }
}
