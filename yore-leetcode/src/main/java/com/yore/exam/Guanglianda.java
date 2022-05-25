package com.yore.exam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/5/24 19:22
 * @description
 */
public class Guanglianda {

    public static void main(String[] args) {
        String input = "#938765";
        System.out.println(calCount(input));
    }

    public static int calCount(String input) {
        int count = 0;
        Map<Integer, Integer> binaryMap = new HashMap<>();
        binaryMap.put(0, 0x3f);
        binaryMap.put(1, 0x06);
        binaryMap.put(2, 0x5b);
        binaryMap.put(3, 0x4f);
        binaryMap.put(4, 0x66);
        binaryMap.put(5, 0x6d);
        binaryMap.put(6, 0x7d);
        binaryMap.put(7, 0x07);
        binaryMap.put(8, 0x7f);
        binaryMap.put(9, 0x6f);

        int pre = 0;
        for (int i = 1; i < input.length(); i++) {
            count += Integer.bitCount(binaryMap.get(Integer.valueOf(input.charAt(i) - '0')) ^ pre);
            pre = binaryMap.get(Integer.valueOf(input.charAt(i) - '0'));
        }
        return count;
    }
}
