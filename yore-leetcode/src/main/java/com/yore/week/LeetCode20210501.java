package com.yore.week;

/**
 * @author jia bing wen
 * @date 2021/5/1 22:37
 * @description
 */
public class LeetCode20210501 {
    public static void main(String[] args) {

        System.out.println(replaceDigits("a1c1e1"));
    }

    public static String replaceDigits(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        sb.append(s.charAt(0));
        char current;
        int offset = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(s.charAt(i));
            } else {
                current = s.charAt(i - 1);
                offset = Integer.valueOf(String.valueOf(s.charAt(i)));
                current = (char) ((int) current + offset);
                sb.append(current);
            }
        }
        return sb.toString();
    }
}
