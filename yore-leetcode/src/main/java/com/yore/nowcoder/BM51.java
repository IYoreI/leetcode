package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/6/13 8:42
 * @description
 */
public class BM51 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        if (n == 1) {
            return array[0];
        }
        int pre = array[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (cnt == 0) {
                pre = array[i];
                cnt = 1;
            } else if (pre == array[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return pre;
    }
}
