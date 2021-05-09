package com.yore.algorithm;

/**
 * @author jia bing wen
 * @date 2021/5/9 20:21
 * @description 超级水王问题
 */
public class SuperWaterKing {

    public static void main(String[] args) {
        System.out.println(waterKing(new int[]{2,3,3,4,5,1,2,3,3,3,3,3,5,3,3,6,7}));
    }

    public static int waterKing(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int candidate = 0;
        int restHp = 0;
        for (int current : array) {
            if (restHp == 0) {
                candidate = current;
                restHp = 1;
            } else if (current != candidate) {
                restHp--;
            } else {
                restHp++;
            }
        }

        if (restHp == 0) {
            return -1;
        }
        int count = 0;
        for (int num : array) {
            if (num == candidate) {
                count++;
            }
        }
        return count > (array.length >> 1) ? candidate : -1;
    }
}
