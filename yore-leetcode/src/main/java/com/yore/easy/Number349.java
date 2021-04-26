package com.yore.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jia bing wen
 * @date 2021/4/25 12:18
 * @description
 */
public class Number349 {
    public static void main(String[] args) {
        int[] res = intersection(new int[]{4,9,5},new int[]{9,4,9,8,4});
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int j : nums2) {
            if (set.contains(j)) {
                result.add(j);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (int a : result) {
            res[i++] = a;
        }
        return res;
    }
}
