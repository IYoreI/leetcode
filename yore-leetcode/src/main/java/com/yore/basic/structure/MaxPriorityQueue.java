package com.yore.basic.structure;

/**
 * @author Yore
 * @date 2021/11/9 9:30
 * @description
 */

/**
 * 大顶堆
 */
public class MaxPriorityQueue {

    private int[] queue;
    private int N = 0;

    private MaxPriorityQueue(int cap) {
        //索引0不用，所以多一个位置，方便计算父子节点位置
        queue = new int[cap + 1];
    }
    //返回当前队列的最大元素
    private int max() {
        return queue[1];
    }
    //父节点索引位置
    private int parent(int node) {
        return node / 2;
    }
    //左子节点索引位置
    private int left(int node) {
        return node * 2;
    }
    //右子节点索引位置
    private int right(int node) {
        return node * 2 + 1;
    }

    /**
     * 插入一个元素的操作，先将元素置为末尾，然后执行上浮操作
     */
    public void insert(int val) {
        N++;
        queue[N] = val;
        swim(N);
    }

    /**
     * 删除堆顶元素，将数组末尾元素放在堆顶，然后执行下沉操作
     */
    public int delMax() {
        int max = queue[1];
        exch(1, N);
        //设置无效
        queue[N] = Integer.MAX_VALUE;
        N--;
        sink(1);
        return max;
    }

    /**
     * 上浮第k个元素
     * 不断比较子节点和父节点的大小，如果父节点小于子节点就相互交换
     */
    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /**
     * 下沉第k个元素
     * 循环条件索引位置没有超过数组末尾
     * 1. 先比较左右子节点位置的元素，找出较大的元素
     * 2. 如果较大的元素没有位置k的元素大，则下沉操作结束
     * 3. 如果较大的元素比位置k的元素大，则交换两个位置的元素，k指向交换后的位置，继续进行下沉操作
     */
    private void sink(int k) {
        while (left(k) <= N) {
            int older = left(k);
            if (right(k) <= N && less(older, right(k))) {
                older = right(k);
            }
            if (less(older, k)) {
                break;
            }
            exch(older, k);
            k = older;
        }
    }

    private void exch(int i, int j) {
        int tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }

    private boolean less(int i, int j) {
        return queue[i] < queue[j];
    }
}
