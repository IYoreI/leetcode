package com.yore.week;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/5/16 8:31
 * @description
 */
public class LeetCode20210516 {
    int res = 0;
    Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

    }


    public int subsetXORSum(int[] nums) {
        dfs(0, nums.length, nums);
        return res;
    }

    public void dfs(int index, int size, int[] nums) {
        if (index == size) {
            int sum = 0;
            int len = stack.size();
            for (int i = 0; i < len; i++) {
                sum ^= stack.elementAt(i);
            }
            res += sum;
            return;
        }

        stack.push(nums[index]);
        dfs(index + 1, size, nums);
        stack.pop();
        dfs(index + 1, size, nums);
    }


    class FindSumPairs {
        int[] num1;
        int[] num2;

        Map<Integer, Integer> map = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.num1 = nums1;
            this.num2 = nums2;
            for (int j : nums2) {
                if (map.containsKey(j)) {
                    map.put(j, map.get(j) + 1);
                } else {
                    map.put(j, 1);
                }
            }
        }

        public void add(int index, int val) {
            map.put(num2[index], map.get(num2[index]) - 1);
            num2[index] += val;
            map.put(num2[index], map.containsKey(num2[index]) ? map.get(num2[index]) + 1 : 1);
        }

        public int count(int tot) {
            int count = 0;
            for (int j : num1) {
                if (map.containsKey(tot - j)) {
                    count += map.get(tot - j);
                }
            }
            return count;
        }
    }
}
