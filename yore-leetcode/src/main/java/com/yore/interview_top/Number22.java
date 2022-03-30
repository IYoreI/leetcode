package com.yore.interview_top;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yore
 * @date 2022/3/30 10:29
 * @description
 */
public class Number22 {
    public List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        process(new StringBuilder(""), n, 0, 0);
        return list;
    }

    public void process(StringBuilder sb, int n, int l, int r) {
        if (sb.length() == 2 * n) {
            list.add(new String(sb));
            return;
        }
        if (l < n) {
            sb.append("(");
            process(sb, n, l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(")");
            process(sb, n, l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
