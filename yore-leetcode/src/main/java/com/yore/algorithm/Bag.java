package com.yore.algorithm;

/**
 * @author Yore
 * @date 2022/3/4 15:38
 * @description 背包问题： 0-1背包
 */
public class Bag {


    public static void main(String[] args) {
        Bag bag = new Bag();
        int[] weights = new int[]{2, 3, 2, 3, 5, 1};
        int[] values = new int[]{1, 1, 3, 3, 2, 7};
        System.out.println(bag.maxValue(weights, values, 10));
        System.out.println(bag.dpWay(weights, values, 10));
        System.out.println(bag.dpWay2(weights, values, 10));
        System.out.println(bag.dpWay3(weights, values, 10));
    }

    /**
     * 问题描述： 有一组物品，weights和values分别记录了每一个物品的重量和价值，
     * 给定一个容量为bag大小的背包，求解在不超过容量的情况下能获得的最大价值是多少
     * 思路1： 在不超过容量的情况下，对于每一个物品，都有两种选择，装入背包或者不装入背包
     * 求解在所有可能的情况中，最大的价值
     *
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public int maxValue(int[] weights, int[] values, int bag) {
        return process(weights, values, 0, bag);
    }

    public int process(int[] weights, int[] values, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (index >= weights.length) {
            return 0;
        }
        int p1 = process(weights, values, index + 1, rest);
        int p2 = -1;
        int p2Next = process(weights, values, index + 1, rest - weights[index]);
        if (p2Next != -1) {
            p2 = values[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    /**
     * 动态规划解法
     *
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public int dpWay(int[] weights, int[] values, int bag) {
        int n = weights.length;
        int[][] dp = new int[n + 1][bag + 1];
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if (rest - weights[index] >= 0) {
                    p2 = values[index] + dp[index + 1][rest - weights[index]];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public int dpWay2(int[] weights, int[] values, int bag) {
        int n = weights.length;
        // dp[i][j] 代表前1-i个物品,在容量为j的时候可组成的最大价值
        int[][] dp = new int[n + 1][bag + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bag; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - weights[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][bag];
    }

    /**
     * 一维滚动数组，降低空间复杂度
     *
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public int dpWay3(int[] weights, int[] values, int bag) {
        int n = weights.length;
        int[] dp = new int[bag + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bag; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[bag];
    }

}
