package com.yore.nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/6/13 9:07
 * @description
 */
public class BM53 {
    public int minNumberDisappeared(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        int idx = 1;
        while (true) {
            if (map.containsKey(idx)) {
                idx++;
            } else {
                return idx;
            }
        }
    }

    /**
     * 原地哈希
     *
     * @param nums
     * @return
     */
    public int minNumberDisappeared2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] <= 0 ? n + 1 : nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i]) <= n) {
                nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
