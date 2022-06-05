package com.yore.nowcoder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/6/4 11:10
 * @description
 */
public class BM45 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i - queue.peekFirst() >= size) {
                queue.pollFirst();
            }
            if (i >= size - 1) {
                list.add(num[queue.peekFirst()]);
            }
        }
        return list;
    }
}
