package com.yore.week;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/4/18 10:08
 * @description 依图&力扣
 */
public class LeetCode20210418 {

    public static void main(String[] args) {
//        getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});
        getOrder(new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}});
//        getOrder(new int[][]{{7,10},{7,12},{7,5},{7,4},{7,2}});


    }

    public static boolean checkIfPangram(String sentence) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (!map.containsKey(sentence.charAt(i))) {
                map.put(sentence.charAt(i), 1);
            }
        }
        return map.size() == 26;
    }


    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int sumCost = 0;
        for (int cost : costs) {
            if (sumCost + cost <= coins) {
                count++;
                sumCost += cost;
            } else {
                break;
            }
        }
        return count;
    }

    public static int[] getOrder(int[][] tasks) {
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], i);
        }
        int length = tasks.length;
        int[] result = new int[tasks.length];
        Deque<int[]> deque = new LinkedList<>();
        Stack<int[]> tmp = new Stack<>();
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                }
                return o1[0] + 1 - o2[0];
            }
        });
        int index = 1;
        int k = 0;
        deque.offer(tasks[0]);
        int incr = 0;
        boolean flag = false;
        while (index < length || !deque.isEmpty()) {
            if (deque.isEmpty()) {
                deque.offer(tasks[index++]);
            }
            while (!deque.isEmpty() && index < length && (deque.element()[0] == tasks[index][0] ||
                    (flag && incr >= tasks[index][0]))) {
                while (!deque.isEmpty() && deque.element()[1] > tasks[index][1]) {
                    tmp.push(deque.pollLast());
                }
                deque.offer(tasks[index++]);
                while (!tmp.empty()) {
                    deque.offer(tmp.pop());
                }
            }
            int[] element = deque.pollFirst();
            result[k++] = map.get(element);
            if (!flag) {
                incr = element[0] + element[1];
            } else {
                incr += element[1];
            }
            flag = true;
        }
        return result;
    }
}
