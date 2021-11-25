package com.yore.algorithm.sort;

/**
 * @author Yore
 * @date 2021/11/25 9:42
 * @description
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param array 待排序数组
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
