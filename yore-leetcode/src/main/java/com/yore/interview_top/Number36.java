package com.yore.interview_top;

/**
 * @author Yore
 * @date 2022/4/18 9:57
 * @description
 */
public class Number36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] colums = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int index = ch - '0' - 1;
                    rows[i][index]++;
                    colums[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || colums[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
