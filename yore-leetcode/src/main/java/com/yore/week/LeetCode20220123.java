package com.yore.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/23 10:13
 * @description
 */
public class LeetCode20220123 {

    public static void main(String[] args) {
        LeetCode20220123 l = new LeetCode20220123();
//        System.out.println(l.countElements(new int[]{-3,3,3,90}));


        System.out.println(l.rearrangeArray(new int[]{-1, 1}));
    }


    public int countElements(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        int min = 100001;
        int max = -100001;
        int count = 0;
        for (int num : nums) {
            if (num >= max) {
                max = num;
            }
            if (num <= min) {
                min = num;
            }
        }
        for (int num : nums) {
            if (num > min && num < max) {
                count++;
            }
        }
        return count;
    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index =0;
        while(nums[index]<0){
            index++;
        }
        int L1 = index;
        index =0;
        while(nums[index]>0){
            index++;
        }
        int L2 = index;

        while (L1 < nums.length && L2 < nums.length) {
            list.add(nums[L1++]);
            while (L1 < nums.length && nums[L1] < 0) {
                L1++;
            }
            list.add(nums[L2++]);
            while (L2 < nums.length && nums[L2] > 0) {
                L2++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
