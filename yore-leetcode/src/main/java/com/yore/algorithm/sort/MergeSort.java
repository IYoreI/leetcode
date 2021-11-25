package com.yore.algorithm.sort;

/**
 * @author Yore
 * @date 2021/11/25 9:54
 * @description
 */
public class MergeSort {

    /**
     * 归并排序
     */
    static int[] nums, tmp;

    public static void mergeSortEnter(int[] arr) {
        nums = arr;
        tmp = new int[nums.length];
        mergeSort(0, nums.length - 1);
    }

    public static void mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) {
            return;
        }
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
            }
        }
    }


    /**
     * 归并排序 版本2
     */

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        process(arr, 0, length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] helper = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            helper[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[index++] = arr[p1++];
        }
        while (p2 <= R) {
            helper[index++] = arr[p2++];
        }
        for (int i = 0; i < helper.length; i++) {
            arr[L + i] = helper[i];
        }
    }
}
