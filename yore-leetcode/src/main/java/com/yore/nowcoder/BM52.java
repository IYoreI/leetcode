package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/6/13 8:52
 * @description
 */
public class BM52 {
    public int[] FindNumsAppearOnce(int[] array) {
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }
        int diff = xor & (-xor);
        int a = 0;
        int b = 0;
        for (int num : array) {
            if ((num & diff) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return a > b ? new int[]{b, a} : new int[]{a, b};
    }
}
