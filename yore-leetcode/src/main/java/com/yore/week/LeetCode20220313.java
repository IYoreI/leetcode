package com.yore.week;

/**
 * @author Yore
 * @date 2022/3/13 10:03
 * @description
 */
public class LeetCode20220313 {
    public static void main(String[] args) {
        int[][] artifacts = new int[][]{{3,1,4,1},{1,1,2,2},{1,0,2,0},{4,3,4,4},{0,3,1,4},{2,3,3,4}};
        int[][] dig = new int[][]{{0,0},{2,1},{2,0},{2,3},{4,3},{2,4},{4,1},{0,2},{4,0},{3,1},{1,2},{1,3},{3,2}};
        System.out.println(digArtifacts(5,artifacts,dig));
    }


    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] grid = new int[n][n];
        for(int[] r : dig){
            grid[r[0]][r[1]] = 1;
        }
        int count = 0;
        for(int[] cad : artifacts){
            int x1 = cad[0];
            int y1 = cad[1];
            int x2 = cad[2];
            int y2 = cad[3];

            int area = cal(grid,x1,y1,x2,y2);
            System.out.println(area+" "+x1+","+y1+" "+x2+","+y2);
            if(area == (x2-x1+1)*(y2-y1+1)){
                count++;
            }
        }
        return count;
    }


    public static int cal(int[][] grid, int x1, int y1,int x2,int y2){
        int area = 0;
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if(grid[i][j] == 1){
                    area++;
                }else{
                    return 0;
                }
            }
        }
        return area;
    }

}
