package com.yore.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/2/22 9:25
 * @description
 */
public class Tool {

    /**
     * 求一个集合的所有子集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int num : nums) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> clone = new ArrayList<>(list.get(j));
                clone.add(num);
                list.add(clone);
            }
        }
        return list;
    }
}
