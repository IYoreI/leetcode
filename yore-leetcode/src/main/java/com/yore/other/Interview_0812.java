package com.yore.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/1/16 9:29
 * @description
 */
public class Interview_0812 {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] record = new int[n];
        int[][] path = new int[n][n];
        func(n, record, 0, path);
        return res;
    }

    public void func(int n, int[] record, int row, int[][] path) {
        if (row == n) {
            List<String> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder("");
                for (int j = 0; j < n; j++) {
                    if (path[i][j] == 0) {
                        sb.append(".");
                    } else {
                        sb.append("Q");
                    }
                }
                t.add(sb.toString());
            }
            res.add(t);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidPos(record, row, col)) {
                record[row] = col;
                path[row][col] = 1;
                func(n, record, row + 1, path);
                path[row][col] = 0;
            }
        }
    }

    public boolean isValidPos(int[] record, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == record[i] || Math.abs(row - i) == Math.abs(col - record[i])) {
                return false;
            }
        }
        return true;
    }
}
