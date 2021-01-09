package com.yore.easy;

/**
 * Created on 2019/1/29
 *
 * @author jiabingwen
 */

public class Number27 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 4, 5, 6, 4, 8, 4, 9};
        System.out.println(removeElement(array, 4));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int len = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
