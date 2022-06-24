package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/6/23 9:49
 * @description
 */
public class BM67 {
    int[][] offset = new int[][]{{1, 0}, {0, 1}};
    int res = 0;
    int m;
    int n;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        path(0, 0);
        return res;
    }

    public void path(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            res++;
            return;
        }
        for (int[] pos : offset) {
            int x = row + pos[0];
            int y = col + pos[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                path(x, y);
            }
        }
    }
    
    /**
     * dp解法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_DP(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
