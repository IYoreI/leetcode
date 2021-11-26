package com.yore.algorithm.sort;

/**
 * @author Yore
 * @date 2021/11/26 10:40
 * @description
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 8, 4, 2, 9, -1, 6, 4, 9, 3, 5};
        headSort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void headSort(int[] arr){
        MaxPriorityQueue heap = new MaxPriorityQueue(arr.length);
        for(int i=0;i<arr.length;i++){
            heap.insert(arr[i]);
        }
        int index = 0;
        while(!heap.isEmpty()){
            arr[index++] = heap.delMax();
        }
    }
}
