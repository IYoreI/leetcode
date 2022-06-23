package com.yore.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yore
 * @date 2022/6/22 11:03
 * @description
 */
public class BM58 {
    ArrayList<String> res = new ArrayList<>();
    int[] visit;

    public ArrayList<String> Permutation(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        visit = new int[str.length()];
        backTrack(ch, new StringBuilder(""));
        return res;
    }

    public void backTrack(char[] ch, StringBuilder sb) {
        if (sb.length() == ch.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (visit[i] == 1 || (i > 0 && ch[i] == ch[i - 1] && visit[i - 1] == 1)) {
                continue;
            }
            sb.append(ch[i]);
            visit[i] = 1;
            backTrack(ch, sb);
            visit[i] = 0;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
