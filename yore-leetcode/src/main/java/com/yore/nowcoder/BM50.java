package com.yore.nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/6/11 9:50
 * @description
 */
public class BM50 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (indexMap.containsKey(target - numbers[i])) {
                return new int[]{indexMap.get(target - numbers[i]) + 1, i + 1};
            } else {
                indexMap.put(numbers[i], i);
            }
        }
        return new int[]{};
    }
}
