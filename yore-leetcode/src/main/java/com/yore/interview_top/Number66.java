package com.yore.interview_top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Yore
 * @date 2021/12/13 10:54
 * @description
 */
public class Number66 {

    public static void main(String[] args) {
        Number66 n = new Number66();
        System.out.println(n.plusOne1(new int[]{9,9,9}));
    }

    public int[] plusOne(int[] digits) {

        Stack<Integer> st = new Stack<>();
        int length = digits.length;
        int carry = 1;
        for (int i = length - 1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] >= 10) {
                digits[i] = 0;
            } else {
                carry = 0;
            }
            st.push(digits[i]);
        }
        if (carry == 1) {
            st.push(carry);
        }
        int index = 0;
        int[] res = new int[st.size()];
        while (!st.isEmpty()) {
            res[index++] = st.pop();
        }
        return res;
    }

    //  best
    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
