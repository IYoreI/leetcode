package com.yore.algorithm;

/**
 * @author jia bing wen
 * @date 2021/5/10 9:37
 * @description 查找算法
 */
public class SearchAlgorithm {
    public static void main(String[] args) {
        SearchAlgorithm s = new SearchAlgorithm();
        System.out.println(s.rightIndex(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));
        System.out.println(s.rightBound(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));
        System.out.println(s.searchRight(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));

        System.out.println("----------------------------");
        System.out.println(s.leftIndex(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));
        System.out.println(s.leftBound(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));
        System.out.println(s.searchLeft(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));

//
//        System.out.println(s.rightIndex(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, -1));
//        System.out.println(s.rightBound(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, -1));
//        System.out.println(s.searchRight(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, -1));
//
//        System.out.println(s.rightIndex(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 3));
//        System.out.println(s.rightBound(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 3));
//        System.out.println(s.searchRight(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 3));
//
//        System.out.println(s.rightIndex(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 4));
//        System.out.println(s.rightBound(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 4));
//        System.out.println(s.searchRight(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 4));
//
//        System.out.println(s.rightIndex(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 9));
//        System.out.println(s.rightBound(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 9));
//        System.out.println(s.searchRight(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 9));
//        System.out.println(s.search(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5}, 1));
    }


    /**
     * ① 查找目标值下标
     * ② 查找目标值左侧边界
     * ③ 查找目标值右侧边界
     * 统一方法： 区间是闭区间 while循环就是<=
     */

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            System.out.println(mid);
            if (nums[mid] == target) {
                //更新区间
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //左边界  检查越界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
//            System.out.println(mid);
            if (nums[mid] == target) {
                //更新区间
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 右边界 检查越界
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


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

    public int leftIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
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

    public int rightIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] <= target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }


    public int getLessIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 || nums[0] < nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] < nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int left = 1;
        int right = nums.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] > nums[mid - 1]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }


}
