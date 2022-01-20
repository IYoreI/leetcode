package com.yore.medium;

/**
 * @author jia bing wen
 * @date 2021/6/16 9:52
 * @description
 */
public class Number877 {
    /**
     * 思路清晰  时间复杂度高  优化为DP
     *
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f_record = new int[n][n];
        int[][] s_record = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f_record[i][j] = -1;
                s_record[i][j] = -1;
            }
        }
        return f(piles, 0, piles.length - 1, f_record, s_record) > s(piles, 0, piles.length - 1, f_record, s_record);
    }

    public int f(int[] piles, int L, int R, int[][] f_record, int[][] s_record) {
        if (f_record[L][R] != -1) {
            return f_record[L][R];
        }
        if (L == R) {
            f_record[L][R] = piles[L];
            return f_record[L][R];
        }
        f_record[L][R] = Math.max(piles[L] + s(piles, L + 1, R, f_record, s_record), piles[R] + s(piles, L, R - 1, f_record, s_record));
        return f_record[L][R];
    }

    public int s(int[] piles, int L, int R, int[][] f_record, int[][] s_record) {
        if (s_record[L][R] != -1) {
            return s_record[L][R];
        }
        if (L == R) {
            s_record[L][R] = 0;
            return 0;
        }
        s_record[L][R] = Math.min(f(piles, L + 1, R, f_record, s_record), f(piles, L, R - 1, f_record, s_record));
        return s_record[L][R];
    }
}
