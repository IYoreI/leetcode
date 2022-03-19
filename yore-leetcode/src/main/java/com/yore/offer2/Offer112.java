package com.yore.offer2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/19 9:08
 * @description
 */
public class Offer112 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] op = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int x = 0, y = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                if (min > matrix[i][j]) {
                    min = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] a = queue.pollFirst();
            x = a[0];
            y = a[1];
            for (int i = 0; i < 4; i++) {
                int r = x - op[i][0];
                int c = y - op[i][1];
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    if (matrix[r][c] > matrix[x][y]) {
                        dp[r][c] += 1;
                        queue.offerLast(new int[]{r, c});
                    }
                }
            }
        }
        int max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
