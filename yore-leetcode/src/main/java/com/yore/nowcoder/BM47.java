package com.yore.nowcoder;

import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/6/21 9:09
 * @description
 */
public class BM47 {
    public int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        for (int num : a) {
            maxQueue.add(num);
            if (maxQueue.size() > K) {
                maxQueue.poll();
            }
        }
        return maxQueue.peek();
    }

    /**
     * 使用快速排序来解决
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth_2(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    public int quickSort(int[] a, int low, int high, int K) {
        int p = partition(a, low, high);
        if (K == p - low + 1) {
            return a[p];
        } else if (p - low + 1 > K) {
            return quickSort(a, low, p - 1, K);
        }
        return quickSort(a, p + 1, high, K - (p - low + 1));
    }

    public int partition(int[] a, int low, int high) {
        if (low >= high) {
            return -1;
        }
        swap(a, (int) (Math.random() * (high - low + 1)) + low, high);
        int cur = low;
        int left = low;
        int right = high;
        while (cur < right) {
            if (a[cur] > a[high]) {
                swap(a, cur++, left++);
            } else if (a[cur] == a[high]) {
                cur++;
            } else {
                swap(a, cur, --right);
            }
        }
        swap(a, cur, high);
        return cur;
    }

    public void swap(int[] num, int idx1, int idx2) {
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }
}
