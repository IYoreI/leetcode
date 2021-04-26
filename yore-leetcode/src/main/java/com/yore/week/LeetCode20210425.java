package com.yore.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jia bing wen
 * @date 2021/4/25 10:25
 * @description
 */
public class LeetCode20210425 {
    public static void main(String[] args) {
//        System.out.println(sumBase(34, 6));
        System.out.println(maxFrequency(new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966
        }, 3056));
//        System.out.println(maxFrequency(new int[]{1,2,4},5));
    }

    public static int sumBase(int n, int k) {
        int num = 0;
        int index = 0;
        while (n >= Math.pow(k, index)) {
            index++;
        }
        index--;
        while (n > 0) {
            if (n >= Math.pow(k, index)) {
                n -= Math.pow(k, index);
                num++;
            } else {
                index--;
            }
        }
        return num;
    }


    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        int maxCount = 0;
        int tmpCount = 1;
        int sum = 0;

        int begin = 0;
        int end = 0;
//        while (end <= diff.length - 1) {
//            while (begin <= end && end <= diff.length - 1) {
//                sum += tmpCount * diff[end];
//                if (sum <= k) {
//                    tmpCount++;
//                    end++;
//                }
//            }
//            maxCount = Math.max(maxCount, tmpCount);
//            int count = 1;
//            while (begin <= end && sum > k) {
//                begin++;
//                sum -= count * diff[begin];
//                tmpCount--;
//                count++;
//            }
//        }
//        return maxCount;
        for (int i = 0; i < diff.length - 1; i++) {
            tmpCount = 1;
            sum = 0;
            for (int j = i; j < diff.length; j++) {
                sum += (tmpCount * diff[j]);
                if (sum <= k) {
                    tmpCount++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, tmpCount);
        }
        return maxCount;
    }


    /**
     * 3
     *
     * @param word
     * @return
     */
    public static int longestBeautifulSubstring(String word) {
        Map<Character, Character> map = new HashMap<>();
        map.put('a', 'e');
        map.put('e', 'i');
        map.put('i', 'o');
        map.put('o', 'u');
        map.put('u', 'u');
        Stack<Character> stack = new Stack<>();
        int maxCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (stack.isEmpty() && word.charAt(i) == 'a') {
                stack.push(word.charAt(i));
            } else if (!stack.isEmpty() && (word.charAt(i) == stack.peek() ||
                    map.get(stack.peek()) == word.charAt(i))) {
                stack.push(word.charAt(i));
            } else if (!stack.isEmpty() && stack.peek() == 'u') {
                maxCount = Math.max(maxCount, stack.size());
                stack = new Stack<>();
                if (word.charAt(i) == 'a') {
                    stack.push(word.charAt(i));
                }
            } else {
                stack = new Stack<>();
                if (word.charAt(i) == 'a') {
                    stack.push(word.charAt(i));
                }
            }
        }
        if (!stack.isEmpty() && stack.peek() == 'u') {
            maxCount = Math.max(maxCount, stack.size());
        }
        return maxCount;
    }

}
