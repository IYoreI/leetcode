package com.yore.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/4/17 10:15
 * @description
 */
public class LeetCode20220417 {
    public static void main(String[] args) {

    }

    List<Integer>[] list;
    int ans;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            list[parent[i]].add(i);
        }
        process(s, 0);
        return ans + 1;
    }

    int process(String s, int index) {
        int maxLen = 0;
        for (int child : list[index]) {
            int len = process(s, child) + 1;
            if (s.charAt(child) != s.charAt(index)) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    // Number 6072
    public int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] r2 = new int[m+1][];
        int[][] c2 = new int[m+1][];
        int[][] r5 = new int[m+1][];
        int[][] c5 = new int[m+1][];
        for(int i=0;i<=m;i++){
            r2[i] = new int[n+1];
            c2[i] = new int[n+1];
            r5[i] = new int[n+1];
            c5[i] = new int[n+1];
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int x = grid[i-1][j-1];
                int two = 0;
                int five = 0;
                while(x%2==0){
                    two++;
                    x/=2;
                }
                while(x%5==0){
                    five++;
                    x/=5;
                }
                r2[i][j] = r2[i][j-1]+two;
                c2[i][j] = c2[i-1][j] +two;
                r5[i][j] = r5[i][j-1]+five;
                c5[i][j] = c5[i-1][j]+five;
            }
        }
        int ans = 0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // 左 -> 上
                ans = Math.max(ans,Math.min(r2[i][j]+c2[i-1][j],r5[i][j]+c5[i-1][j]));
                // 左 -> 下
                ans = Math.max(ans,Math.min(r2[i][j]+c2[m][j]-c2[i][j],r5[i][j]+c5[m][j]-c5[i][j]));
                // 右 -> 上
                ans = Math.max(ans,Math.min(r2[i][n]-r2[i][j]+c2[i][j],r5[i][n]-r5[i][j]+c5[i][j]));
                // 右 -> 下
                ans = Math.max(ans,Math.min(r2[i][n]-r2[i][j]+c2[m][j]-c2[i-1][j],r5[i][n]-r5[i][j]+c5[m][j]-c5[i-1][j]));
            }
        }
        return ans;
    }













}
