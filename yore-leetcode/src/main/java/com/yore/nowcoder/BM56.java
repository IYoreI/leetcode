package com.yore.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/6/2 14:27
 * @description
 */
public class BM56 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int[] visit;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        visit = new int[num.length];
        Arrays.sort(num);
        backTrack(num, new LinkedList<>());
        return res;
    }

    public void backTrack(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visit[i - 1] == 1)) {
                continue;
            }
            list.add(nums[i]);
            visit[i] = 1;
            backTrack(nums, list);
            visit[i] = 0;
            list.removeLast();
        }
    }
}
