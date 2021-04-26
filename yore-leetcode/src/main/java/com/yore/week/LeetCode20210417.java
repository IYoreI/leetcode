package com.yore.week;

/**
 * @author jia bing wen
 * @date 2021/4/17 22:22
 * @description 滴滴&力扣
 */
public class LeetCode20210417 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 5, 2, 4, 1};
//        System.out.println(minOperations(nums));

        int[][] points = new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}};
        int[][] queries = new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}};
        int[] result = countPoints(points, queries);
        System.out.println(result);
    }

    public static int minOperations(int[] nums) {
        int count = 0;
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else {
                max++;
                count += (max - nums[i]);
            }
        }
        return count;
    }


    public static int[] countPoints(int[][] points, int[][] queries) {
        int length = queries.length;
        int[] result = new int[length];
        int count = 0;
        int rX, rY;
        int radius;
        double distance = 0.0;
        for (int i = 0; i < length; i++) {
            count = 0;
            rX = queries[i][0];
            rY = queries[i][1];
            radius = queries[i][2];
            for (int[] point : points) {
                distance = Math.sqrt(Math.pow(point[0] - rX, 2) + Math.pow(point[1] - rY, 2));
                if (distance <= radius) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }


    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int max = (int) Math.pow(2, maximumBit);
        int x = nums[0];
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 1; i < length; i++) {
            x = x ^ nums[i];
        }
        int maxResult;
        int tmp;
        int index;
        maxResult = -1;
        index = 0;
        for (int k = 0; k < max; k++) {
            tmp = x ^ k;
            if (tmp > maxResult) {
                maxResult = tmp;
                index = k;
            }
        }
        result[0] = index;
        int k = length - 1;
        for (int j = 1; j < length; j++) {
            result[j] = index ^ nums[k];
            index = result[j];
            k--;
        }
        return result;
    }
}
