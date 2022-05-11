package com.yore.nowcoder;

import java.util.Stack;

/**
 * @author Yore
 * @date 2022/5/10 9:45
 * @description
 */
public class BM43 {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        st.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else {
            min.push(Math.min(node, min.peek()));
        }
    }

    public void pop() {
        st.pop();
        min.pop();
    }

    public int top() {
        return st.peek();
    }

    public int min() {
        return min.peek();
    }
}
