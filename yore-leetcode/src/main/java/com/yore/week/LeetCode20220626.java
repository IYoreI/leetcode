package com.yore.week;

import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/6/26 10:36
 * @description
 */
public class LeetCode20220626 {

    public static void main(String[] args) {
        int[] nums1 = {60, 60, 60};
        int[] nums2 = {10, 90, 10};
        System.out.println(maximumsSplicedArray(nums1, nums2));
    }

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((i==j || i+j+1 == n) && grid[i][j]==0){
                    return false;
                }
                if(i!=j && i+j+1!=n && grid[i][j]!=0){
                    return false;
                }
            }
        }
        return true;
    }

    public int countHousePlacements(int n) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        int mod = (int)Math.pow(10,9)+7;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]%mod + dp[i-2]%mod;
        }
        return (int) ((dp[n] * dp[n]) % mod);
    }


    public static int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int a = maximumsSplicedArrayByNums2Base(nums1, nums2);
        int b = maximumsSplicedArrayByNums2Base(nums2, nums1);
        return Math.max(a, b);
    }

    public static int maximumsSplicedArrayByNums2Base(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long dSum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums1[i] - nums2[i]; //当前差值
            dSum = Math.max(0, dSum + diff); //可不替换,则为0
            dSum = Math.max(diff, dSum); //用当前的数 或 与前面的子数组合并, 取大的
            max = Math.max(max, dSum);  //记录过程中的最大值
        }
        return Arrays.stream(nums2).sum() + (int) max;
    }


}
