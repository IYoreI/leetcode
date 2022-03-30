package com.yore.interview_top;

import java.util.*;

/**
 * @author Yore
 * @date 2022/3/30 9:33
 * @description
 */
public class Number17 {
    public List<String> result = new ArrayList<>();
    public Map<Integer, Set<String>> idxMap = new HashMap<>();


    public static void main(String[] args) {
        Number17 number17 = new Number17();
        System.out.println(number17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n <= 0) {
            return result;
        }
        char begin = 'a';
        for (int i = 2; i <= 9; i++) {
            int k = 3;
            if (i == 7 || i == 9) {
                k = 4;
            }
            Set<String> s = new HashSet<>();
            for (int j = 0; j < k; j++) {
                s.add(String.valueOf(begin++));
            }
            idxMap.put(i, s);
        }
        process(digits, 0, new StringBuilder(""));
        return result;
    }

    public void process(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            String t = new String(sb);
            result.add(t);
            return;
        }
        for (String s : idxMap.get(Integer.parseInt(String.valueOf(digits.charAt(index))))) {
            sb.append(s);
            process(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
