package com.yore.algorithm;

/**
 * @author jia bing wen
 * @date 2021/5/10 9:37
 * @description 查找算法
 */
public class SearchAlgorithm {


    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意
        /*
         * 注意循环条件的设置：  <= 或者 <
         * 因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
         * 这二者可能出现在不同功能的二分查找中，区别是：前者相当于两端都闭区间 [left, right]，
         * 后者相当于左闭右开区间 [left,right)，因为索引大小为 nums.length 是越界的
         */
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1; // 注意
            } else if (nums[mid] > target) {
                right = mid - 1; // 注意
            }
        }
        return -1;
    }

    public int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    public int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }

}
