package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/6/29 8:56
 * @description
 */
public class BM73 {
    public int getLongestPalindrome(String A) {
        String longStr = "";
        for (int i = 0; i < A.length(); i++) {
            String s1 = longestPalindrome(A, i, i);
            String s2 = longestPalindrome(A, i, i + 1);
            if (s1.length() > s2.length()) {
                longStr = longStr.length() > s1.length() ? longStr : s1;
            } else {
                longStr = longStr.length() > s2.length() ? longStr : s2;
            }
        }
        return longStr.length();
    }

    public String longestPalindrome(String s, int mid1, int mid2) {
        int n = s.length();
        while (mid1 >= 0 && mid2 < n) {
            if (s.charAt(mid1) != s.charAt(mid2)) {
                break;
            }
            mid1--;
            mid2++;
        }
        return s.substring(++mid1, mid2);
    }
}
