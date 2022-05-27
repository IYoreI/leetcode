package com.yore.exam;

import java.util.*;

/**
 * @author Yore
 * @date 2022/5/24 19:22
 * @description
 */
public class Guanglianda {

    //    public static void main(String[] args) {
//        String input = "#938765";
//        System.out.println(calCount(input));
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = m; i <= n; i++) {
                int sum = 0;
                int num = i;
                while (num != 0) {
                    int t = num % 10;
                    num /= 10;
                    sum += Math.pow(t, 3);
                }
                if (sum == i) {
                    list.add(sum);
                }
            }
            if (list.size() > 0) {
                for (int num : list) {
                    System.out.print(num + " ");
                }
            } else {
                System.out.print("no");
            }
            System.out.println();
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String line = sc.nextLine();
//            String[] content = line.split(" ");
//            DecimalFormat df = new DecimalFormat("0.00");
//            df.setRoundingMode(RoundingMode.HALF_UP);
//            double n = Integer.valueOf(content[0]);
//            int m = Integer.valueOf(content[1]);
//            double result = 0.0;
//            while (m > 0) {
//                result +=n;
//                n = Math.sqrt(n);
//                m--;
//            }
//            System.out.println(df.format(result));
//        }
//    }


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
