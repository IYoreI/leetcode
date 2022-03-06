package com.yore.week;

import com.yore.base.TreeNode;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/6 10:37
 * @description
 */
public class LeetCode20220306 {
    public static void main(String[] args) {
        LeetCode20220306 l = new LeetCode20220306();
//        System.out.println(l.cellsInRange("K1:L2"));
//        System.out.println(l.minimalKSum(new int[]{96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84}, 35));
        System.out.println(l.minimalKSum(new int[]{1, 4, 25, 10, 25}, 2));
//        System.out.println(l.createBinaryTree(new int[][]{{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}}));


    }


    public List<String> cellsInRange(String s) {
        String[] str = s.split(":");
        char a = str[0].charAt(0);
        int r = Integer.parseInt(String.valueOf(str[0].charAt(1)));
        char b = str[1].charAt(0);
        int e = Integer.parseInt(String.valueOf(str[1].charAt(1)));
        List<String> list = new ArrayList<>();
        char t = a;
        while (t >= a && t <= b) {
            for (int i = r; i <= e; i++) {
                list.add(t + String.valueOf(i));
            }
            t++;
        }
        return list;
    }


    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0L;
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= left) {
                int interval = nums[i] - left;
                if (k < interval) {
                    sum += k * (long) (left + k - 1 + left) / 2;
                    return sum;
                } else {
                    k -= interval;
                    sum += interval * (long) (nums[i] - 1 + left) / 2;
                    left = nums[i] + 1;
                }
            }
        }
        if (k > 0) {
            sum += k * (long) (left + k - 1 + left) / 2;
        }
        return sum;
    }


    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] node : descriptions) {
            int parent = node[0];
            int child = node[1];
            int left = node[2];
            set.add(child);
            TreeNode p;
            if (map.containsKey(parent)) {
                p = map.get(parent);
            } else {
                p = new TreeNode(parent);
                map.put(parent, p);
            }
            TreeNode c;
            if (map.containsKey(child)) {
                c = map.get(child);
            } else {
                c = new TreeNode(child);
                map.put(child, c);
            }
            if (left == 1) {
                p.left = c;
            } else {
                p.right = c;
            }
        }
        for (int[] n : descriptions) {
            if (!set.contains(n[0])) {
                return map.get(n[0]);
            }
        }
        return null;
    }
}
