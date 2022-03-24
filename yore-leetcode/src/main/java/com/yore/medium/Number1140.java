package com.yore.medium;

/**
 * @author Yore
 * @date 2022/3/23 10:00
 * @description
 */
public class Number1140 {
    public static void main(String[] args) {
        System.out.println((int)Math.floor(0.9));
    }
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len + 1][len + 1];
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int m = 1; m <= len; m++) {
                if (i + 2 * m >= len) {
                    dp[i][m] = sum;
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], sum - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
