package com.yore.algorithm.sort;

/**
 * @author Yore
 * @date 2021/11/25 9:53
 * @description
 */
public class InsertSort {
    /**
     * 插入排序
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
