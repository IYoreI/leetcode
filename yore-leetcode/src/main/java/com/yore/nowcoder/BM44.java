package com.yore.nowcoder;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/6/2 10:01
 * @description
 */
public class BM44 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0) {
            return true;
        }
        Deque<Character> queue = new LinkedList<>();
        queue.offerLast(s.charAt(0));
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                queue.offerLast(ch);
            } else {
                if (queue.isEmpty()) {
                    return false;
                }
                char c = queue.peekLast();
                if (ch - c == 1 || ch - c == 2) {
                    queue.pollLast();
                } else {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}
