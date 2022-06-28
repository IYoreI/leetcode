package com.yore.nowcoder;

import java.util.ArrayList;

/**
 * @author Yore
 * @date 2022/6/28 9:43
 * @description
 */
public class BM60 {
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int n) {
        dfs("", n, 0, 0);
        return res;
    }

    public void dfs(String str, int n, int left, int right) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        if (left < n) {
            dfs(str + "(", n, left + 1, right);
        }
        if (right < n && left > right) {
            dfs(str + ")", n, left, right + 1);
        }
    }
}
