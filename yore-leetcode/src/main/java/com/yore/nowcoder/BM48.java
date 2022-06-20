package com.yore.nowcoder;

import java.util.PriorityQueue;

/**
 * @author Yore
 * @date 2022/6/20 9:45
 * @description
 */
public class BM48 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));

    public void Insert(Integer num) {
        if (minHeap.size() != maxHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        return minHeap.size() != maxHeap.size() ? (double) minHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
