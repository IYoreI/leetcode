package com.yore.nowcoder;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/6/22 9:48
 * @description
 */
public class BM57 {
    int[][] position = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] visit;

    public int solve(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || visit[i][j] == 1) {
                    continue;
                }
                search(grid, i, j);
                res++;
            }
        }
        return res;
    }

    public void search(char[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] card = queue.pollFirst();
            for (int[] pos : position) {
                int x = card[0] + pos[0];
                int y = card[1] + pos[1];
                if (x >= 0 && x < m && y >= 0 && y < n && visit[x][y] == 0 && grid[x][y] == '1') {
                    queue.offerLast(new int[]{x, y});
                    visit[x][y] = 1;
                }
            }
        }
    }
}
