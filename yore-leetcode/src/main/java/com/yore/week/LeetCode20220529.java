package com.yore.week;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Yore
 * @date 2022/5/29 11:47
 * @description
 */
public class LeetCode20220529 {
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int result = 0;
        while (true) {
            for (int i = 0; i < target.length(); i++) {
                int idx = target.charAt(i) - 'a';
                if (count[idx] <= 0) {
                    return result;
                }
                count[idx]--;
            }
            result++;
        }
    }

    public String discountPrices(String sentence, int discount) {
        String[] str = sentence.split(" ");
        int n = str.length;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str[i].startsWith("$")) {
                try {
                    double value = Long.valueOf(str[i].substring(1, str[i].length())) * (100 - discount) / 100.0;
                    String val = df.format(value);
                    str[i] = "$" + val;
                } catch (Exception e) {

                }
            }
            sb.append(str[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
