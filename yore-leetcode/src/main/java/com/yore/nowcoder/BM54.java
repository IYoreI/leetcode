package com.yore.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/6/20 9:18
 * @description
 */
public class BM54 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;
        if (n < 3) {
            return res;
        }
        for (int left = 0; left < n - 2; left++) {
            if (left > 0 && num[left] == num[left - 1]) {
                continue;
            }
            for (int mid = left + 1; mid < n - 1; mid++) {
                if (mid > left + 1 && num[mid] == num[mid - 1]) {
                    continue;
                }
                for (int right = mid + 1; right < n; right++) {
                    if (num[left] + num[mid] + num[right] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[left]);
                        list.add(num[mid]);
                        list.add(num[right]);
                        res.add(list);
                        break;
                    }
                    if (num[left] + num[mid] + num[right] > 0) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
