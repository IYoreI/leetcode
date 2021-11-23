package com.yore.algorithm;

/**
 * @author jia bing wen
 * @date 2021/4/19 15:32
 * @description 排序算法
 */
public class SortAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 4, 2, 6, 4, 9, 3, 5};
//        bubbleSort(array);
//        selectSort(array);
//        mergeSortEnter(array);
        mergeSort2(array);
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
