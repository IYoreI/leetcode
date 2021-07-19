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
        mergeSortEnter(array);
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
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                //通过异或运算交换两个数的位置
                if (array[j] < array[j + 1]) {
                    array[j] = array[j] ^ array[j + 1];
                    array[j + 1] = array[j] ^ array[j + 1];
                    array[j] = array[j] ^ array[j + 1];
                }
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
