package com.yore.algorithm;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/3/13 15:48
 * @description
 */
public class Bag2 {


    public static void main(String[] args) {
        Bag2 bag = new Bag2();
        int[] weights = new int[]{1, 3, 4};
        int[] values = new int[]{15, 20, 30};
        int rest = 4;
        System.out.println(bag.maxValue(weights, values, rest));
        int[] dp = new int[rest + 1];
        Arrays.fill(dp, -2);
        System.out.println(bag.processCache(weights, values, rest, dp));
        System.out.println(bag.processDp(weights, values, rest));
    }

    public int maxValue(int[] weights, int[] values, int bag) {
        return process(weights, values, bag);
    }

    /**
     * 递归思路
     *
     * @param weights
     * @param values
     * @param rest
     * @return
     */
    public int process(int[] weights, int[] values, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            int sub = process(weights, values, rest - weights[i]);
            if (sub == -1) {
                continue;
            }
            maxValue = Math.max(maxValue, sub + values[i]);
        }
        return maxValue == Integer.MIN_VALUE ? -1 : maxValue;
    }


    /**
     * 记忆化搜索
     *
     * @param weights
     * @param values
     * @param rest
     * @param dp
     * @return
     */
    public int processCache(int[] weights, int[] values, int rest, int[] dp) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }
        if (dp[rest] != -2) {
            return dp[rest];
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            int sub = process(weights, values, rest - weights[i]);
            if (sub == -1) {
                continue;
            }
            maxValue = Math.max(maxValue, sub + values[i]);
        }
        dp[rest] = (maxValue == Integer.MIN_VALUE ? -1 : maxValue);
        return dp[rest];
    }


    /**
     * DP
     *
     * @param weights
     * @param values
     * @param rest
     * @return
     */
    public int processDp(int[] weights, int[] values, int rest) {
        int[] dp = new int[rest + 1];
        for (int i = 0; i <= rest; i++) {
            for (int j = 0; j < weights.length; j++) {
                if (i - weights[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
        }
        return dp[rest];
    }
}
