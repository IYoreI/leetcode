package com.yore.offer2;

/**
 * @author Yore
 * @date 2022/3/9 10:22
 * @description
 */
public class Offer070 {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
