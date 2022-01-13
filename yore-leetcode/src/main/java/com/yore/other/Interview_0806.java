package com.yore.other;

import java.util.List;

/**
 * @author Yore
 * @date 2022/1/13 14:11
 * @description 汉诺塔问题
 */
public class Interview_0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        func(A.size(), A, C, B);
        int[] a = new int[5];

    }

    public void func(int n, List<Integer> from, List<Integer> to, List<Integer> other) {
        if (n < 1) {
//            to.add(0,from.remove(0));
            return;
        }
        func(n - 1, from, other, to);
        to.add(0,from.remove(0));
        func(n - 1, other, to, from);
    }
}
