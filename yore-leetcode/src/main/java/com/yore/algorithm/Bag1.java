package com.yore.algorithm;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/3/6 16:11
 * @description
 */
public class Bag1 {
    public static void main(String[] args) {
        Bag1 t = new Bag1();
        int[] weights = new int[]{1, 3, 4};
        int[] values = new int[]{15, 20, 30};
        System.out.println(t.maxValue(weights, values, 4));
        System.out.println(t.dpWay(weights, values, 4));
        System.out.println(t.dpWay2(weights, values, 4));
    }


    public int maxValue(int[] weights, int[] values, int bag) {
        int n = weights.length;
        int[][] dp = new int[n + 1][bag + 1];
        for (int[] t : dp) {
            Arrays.fill(t, -1);
        }
        return process1(weights, values, 0, bag);
//        return process2(weights, values, 0, bag, dp);
    }

    /**
     * 递归版本
     *
     * @param weights
     * @param values
     * @param index
     * @param rest
     * @return
     */
    public int process1(int[] weights, int[] values, int index, int rest) {
        if (index == weights.length) {
            return 0;
        }
        // p1 代表 不取当前index位置的物品   index之后的所有物品构成的最大价值
        int p1 = process1(weights, values, index + 1, rest);
        int p2 = -1;
        if (rest >= weights[index]) {
            // p2 代表取了当前index位置的物品  以及之后所有物品能构成的最大价值
            p2 = process1(weights, values, index + 1, rest - weights[index]);
            p2 += values[index];

        }
        return Math.max(p1, p2);
    }

    /**
     * 递归加记忆化搜索，实现中间结果缓存，减少递归调用次数
     *
     * @param weights
     * @param values
     * @param rest    背包剩余容量
     * @param index   物品下标 0 ~ n-1
     *                从当前物品开始以及之后的所有物品，多能构成的最大价值
     * @return
     */
    public int process2(int[] weights, int[] values, int index, int rest, int[][] dp) {
        if (index == weights.length) {
            return 0;
        }
        // p1 代表 不取当前index位置的物品   index之后的所有物品构成的最大价值
        int p1;
        if (dp[index + 1][rest] != -1) {
            p1 = dp[index + 1][rest];
        } else {
            p1 = process2(weights, values, index + 1, rest, dp);
        }

        int p2 = -1;
        if (rest >= weights[index]) {
            // p2 代表取了当前index位置的物品  以及之后所有物品能构成的最大价值
            if (dp[index + 1][rest - weights[index]] != -1) {
                p2 = dp[index + 1][rest - weights[index]];
            } else {
                p2 = process2(weights, values, index + 1, rest - weights[index], dp);
                p2 += values[index];
            }
        }
        dp[index][rest] = Math.max(p1, p2);
        return dp[index][rest];
    }


    /**
     * 动态规划版本
     *
     * @param weights
     * @param values
     * @param bag
     * @return
     */
    public int dpWay(int[] weights, int[] values, int bag) {
        int n = weights.length;
        int[][] dp = new int[n + 1][bag + 1];

        //边界值 赋值
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - weights[index] >= 0) {
                    dp[index][rest] = Math.max(dp[index + 1][rest - weights[index]] + values[index], dp[index][rest]);
                }
            }
        }
        return dp[0][bag];
    }

    public int dpWay2(int[] weights, int[] values, int bag) {
        int n = weights.length;
        int[][] dp = new int[n + 1][bag + 1];
        //边界值 赋值
        for (int rest = 0; rest <= bag; rest++) {
            for (int index = n - 1; index >= 0; index--) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - weights[index] >= 0) {
                    dp[index][rest] = Math.max(dp[index + 1][rest - weights[index]] + values[index], dp[index][rest]);
                }
            }
        }
        return dp[0][bag];
    }
}
