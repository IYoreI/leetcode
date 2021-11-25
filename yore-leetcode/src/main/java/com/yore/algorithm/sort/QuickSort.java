package com.yore.algorithm.sort;

import java.util.Random;

/**
 * @author Yore
 * @date 2021/11/25 9:54
 * @description
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 4, 2, 9, -1, 6, 4, 9, 3, 5};
        quickSort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = partition(arr, L, R);
        process(arr, L, mid - 1);
        process(arr, mid + 1, R);
    }

    public static int partition(int[] arr, int L, int R) {
        if (L >= R) {
            return -1;
        }
        //随机选择元素  复杂度为O(nlog(n))
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int less = L;
        int more = R;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < arr[R]) {
                swap(arr, cur++, less++);
            } else if (arr[cur] == arr[R]) {
                cur++;
            } else {
                swap(arr, cur, --more);
            }
        }
        swap(arr, cur, R);
        return cur;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
