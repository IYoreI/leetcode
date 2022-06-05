package com.yore.nowcoder;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/6/4 11:13
 * @description
 */
public class BM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int num : input) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
