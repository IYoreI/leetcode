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
}
