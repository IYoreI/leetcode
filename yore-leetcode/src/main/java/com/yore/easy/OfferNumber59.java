package com.yore.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yore
 * @date 2021/3/2 15:55
 * @description
 */
public class OfferNumber59 {
    public static void main(String[] args) {
        int[] a = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 4;
        int[] res = getMaxWindow(a, w);

        for (int l : res) {
            System.out.print(l + " ");
        }
    }

    /**
     * 通过双端队列来维护滑动窗口过程中的最大值
     * @param nums
     * @param k
     * @return
     */
    public static int[] getMaxWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                res[index++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}
