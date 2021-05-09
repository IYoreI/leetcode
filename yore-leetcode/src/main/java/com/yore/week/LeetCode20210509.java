package com.yore.week;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jia bing wen
 * @date 2021/5/9 10:25
 * @description
 */
public class LeetCode20210509 {

    public static void main(String[] args) {
//        System.out.println(maximumPopulation(new int[][]{{1993, 1999}, {2000, 2010}}));
//        System.out.println(maxDistance(new int[]{55, 30, 5, 4}, new int[]{100, 20, 10, 10, 5}));
        System.out.println(maxSumMinProduct(new int[]{1, 1, 3, 2, 2, 2, 1, 5, 1, 5}));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] array = new int[2051];
        int begin = 0;
        int end = 0;
        for (int[] log : logs) {
            begin = log[0];
            end = log[1];
            for (int j = begin; j < end; j++) {
                array[j]++;
            }
        }
        int res = -1;
        int max = -1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                res = j;
                max = array[j];
            }
        }
        return res;
    }


    public static int maxDistance(int[] nums1, int[] nums2) {
        int dis = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            j = i;
            while (j < len2 && i <= j && nums1[i] <= nums2[j]) {
                j++;
            }
            dis = Math.max(j - i - 1, dis);
            i++;
        }
        return dis;
    }

    public static int maxSumMinProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int k = 0;
        int minCount = 1;
        while (k < nums.length) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i <= k; i++) {
                queue.offer(nums[i]);
                if (nums[i] < min) {
                    min = nums[i];
                    minCount = 1;
                } else if (nums[i] == min) {
                    minCount++;
                }
                sum += nums[i];
            }
            long product = sum * min;
            max = (int) Math.max(product % (Math.pow(10, 9) + 7), max);
            int j = k + 1;
            while (j < nums.length) {
                queue.offer(nums[j]);
                int number = queue.poll();
                sum = (sum - number + nums[j]);
                if (nums[j] < min) {
                    min = nums[j];
                    minCount = 1;
                } else if (nums[j] == min) {
                    minCount++;
                }
                if (number == min) {
                    minCount--;
                    if (minCount == 0) {
                        Stat s = calMin(nums, j - k, j);
                        min = s.getMin();
                        minCount = s.getMinCount();
                    }
                }
                product = sum * min;
                max = (int) Math.max(product % (Math.pow(10, 9) + 7), max);
                j++;
            }
            k++;
        }
        return max;
    }

    public static Stat calMin(int[] array, int begin, int end) {
        int min = Integer.MAX_VALUE;
        Stat s = new Stat();
        int minCount = 1;
        for (int i = begin; i <= end; i++) {
            if (array[i] < min) {
                min = array[i];
                minCount = 1;
            } else if (array[i] == min) {
                minCount++;
            }
        }
        s.setMin(min);
        s.setMinCount(minCount);
        return s;
    }

    static class Stat {
        int min;
        int minCount;

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMinCount() {
            return minCount;
        }

        public void setMinCount(int minCount) {
            this.minCount = minCount;
        }
    }
}
