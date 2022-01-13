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
    }

    public void func(int n, List<Integer> from, List<Integer> to, List<Integer> other) {
        if (n == 1) {
            to.add(from.get(from.size() - 1));
            from.remove(from.size() - 1);
            return;
        }
        func(n - 1, from, other, to);
        to.add(from.get(from.size() - 1));
        from.remove(from.size() - 1);
        func(n - 1, other, to, from);
    }
}
