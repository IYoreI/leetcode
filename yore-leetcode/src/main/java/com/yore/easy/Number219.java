package com.yore.easy;

/**
 * @author Yore
 * @date 2022/1/19 9:46
 * @description
 */
public class Number219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (j - i > k) {
                    break;
                }
                if (nums[i] == nums[j] && (j - i) <= k) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}
