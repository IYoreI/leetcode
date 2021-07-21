package com.yore.algorithm;

/**
 * @author jia bing wen
 * @date 2021/4/19 15:32
 * @description 排序算法
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 4, 2, 6, 4, 9, 3, 5};
        bubbleSort(array);
//        selectSort(array);
//        mergeSortEnter(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

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

    public static void swapXor(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }


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
}
