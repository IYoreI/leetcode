package com.yore.offer2;

import java.util.*;

/**
 * @author Yore
 * @date 2022/1/17 10:53
 * @description
 */
public class Offer082 {
    public List<List<Integer>> res = new ArrayList<>();
    public Map<String, Integer> map = new HashMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int N = candidates.length;
        int[] record = new int[N];
        Arrays.sort(candidates);
        process(candidates, target, 0, record);
        return res;
    }

    public void process(int[] candidates, int rest, int index, int[] record) {
        if (rest == 0) {
            List<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < record.length; i++) {
                if (record[i] == 1) {
                    list.add(candidates[i]);
                    sb.append(candidates[i]);
                }
            }
            if (!map.containsKey(sb.toString())) {
                res.add(list);
                map.put(sb.toString(), 1);
            }
            return;
        }
        if (index == candidates.length || candidates[index] > rest) {
            return;
        }
        process(candidates, rest, index + 1, record);
        if (rest - candidates[index] >= 0) {
            record[index] += 1;
            process(candidates, rest - candidates[index], index + 1, record);
            record[index] -= 1;
        }
    }
}
