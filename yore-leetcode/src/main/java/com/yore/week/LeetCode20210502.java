package com.yore.week;

/**
 * @author jia bing wen
 * @date 2021/5/2 11:16
 * @description
 */
public class LeetCode20210502 {
    public static void main(String[] args) {

    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(Math.abs(i - start), min);
            }
        }
        return min;
    }
}
