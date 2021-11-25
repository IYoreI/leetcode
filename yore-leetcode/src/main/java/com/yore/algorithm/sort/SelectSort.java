package com.yore.algorithm.sort;

/**
 * @author Yore
 * @date 2021/11/25 9:44
 * @description
 */
public class SelectSort {
    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
