package com.yore.hard;

/**
 * @author yore
 * @date 2021/3/28 9:48
 * @description
 */
public class Number10 {

    public static void main(String[] args) {

    }


    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (s.length() == 0) {
            return false;
        }
        if (p.length() == 0) {
            return false;
        }

        char currentMatchChar = '@';

        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (j == p.length()) {
                break;
            }
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                currentMatchChar = s.charAt(i);
                i++;
                j++;
            }
            if ((s.charAt(i) == currentMatchChar && p.charAt(j) == '*')) {

            }
            i++;
        }
        if (i == s.length() && j == p.length()) {
            return true;
        }

        return false;
    }


}
