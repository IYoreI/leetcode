package com.yore.competition;

import java.util.Arrays;

/**
 * @author jia bing wen
 * @date 2021/4/5 14:33
 * @description 力扣个人赛  2021年4月5日
 */
public class LeetCode20210405 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 9};
        System.out.println(purchasePlans(nums, 10));
//
//        System.out.println(orchestraLayout(20, 14, 15));
    }

    public static int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);

        int count = 0;
        int beginIndex = 0;
        int endIndex = nums.length - 1;
        while (beginIndex < endIndex) {
            while ((endIndex > beginIndex) && (nums[beginIndex] + nums[endIndex] > target)) {
                endIndex--;
            }
            count = (count+ endIndex - beginIndex) % (1000000007);
            beginIndex++;
        }
        return (int) (count % (1000000007));
    }

    /**
     * 画螺旋矩阵
     *
     * @param num
     * @param xPos
     * @param yPos
     * @return
     */
    public static int orchestraLayout(int num, int xPos, int yPos) {
        int[][] matrix = new int[num][num];
        int rowLow = 0;
        int rowHigh = num - 1;
        int colLow = 0;
        int colHigh = num - 1;
        int number = 1;
        int i = 0;
        int j = 0;
        int count = 0;
        while (count < num * num) {
            while (j <= colHigh) {
                number = number > 9 ? 1 : number;
                matrix[i][j] = number;

//                if(i==xPos && j==yPos){
//                    return number;
//                }
                number++;
                count++;
                j++;
            }
            j--;
            rowLow++;
            i = rowLow;
            while (i <= rowHigh) {
                number = number > 9 ? 1 : number;
//                if(i==xPos && j==yPos){
//                    return number;
//                }
                matrix[i][j] = number;
                number++;
                count++;
                i++;
            }

            i--;
            colHigh--;
            j = colHigh;
            while (j >= colLow) {
                number = number > 9 ? 1 : number;
//                if(i==xPos && j==yPos){
//                    return number;
//                }
                matrix[i][j] = number;
                number++;
                count++;
                j--;
            }
            j++;
            rowHigh--;
            i = rowHigh;
            while (i >= rowLow) {
                number = number > 9 ? 1 : number;
//                if(i==xPos && j==yPos){
//                    return number;
//                }
                matrix[i][j] = number;
                number++;
                count++;
                i--;
            }
            i++;
            colLow++;
            j = colLow;
        }
        for (int k = 0; k < num; k++) {
            for (int l = 0; l < num; l++) {
                System.out.print(matrix[k][l] + " ");
            }
            System.out.println();
        }
        return matrix[xPos][yPos];
    }


}
