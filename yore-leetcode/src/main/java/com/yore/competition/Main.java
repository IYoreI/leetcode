package com.yore.competition;

import java.util.*;

/**
 * @author jia bing wen
 * @date 2021/4/24 13:50
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        for (int j = 0; j < n; j++) {
            int count = 1;
            if (nums[j] == 1) {
                System.out.println(count);
                continue;
            }
            long left = nums[j] / 2;
            long right = nums[j] - left;
            count++;
            while (right != 1) {
                left = right / 2;
                right = right - left;
                count++;
            }
            System.out.println(count);
        }
    }


    public static int recursion(int number) {
        if (number == 1) {
            return 1;
        }
        int left = number / 2;
        int leftCut = recursion(left) + 1;
        int rightCut = recursion(number - left) + 1;
        return Math.max(leftCut, rightCut);
    }

    public static void problem1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int u = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int diff = u - h;
        if (diff <= 0) {
            System.out.println(0);
        } else {
            Arrays.sort(nums);
            int count = 0;
            int index = n - 1;
            while (diff > 0) {
                diff -= nums[index--];
                count++;
            }
            System.out.println(count);
        }
    }

    public void problem2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        for (int j = 0; j < n; j++) {
            int count = 1;
            if (nums[j] == 1) {
                System.out.println(count);
                continue;
            }
            long left = nums[j] / 2;
            long right = nums[j] - left;
            count++;
            while (right != 1) {
                left = right / 2;
                right = right - left;
                count++;
            }
            System.out.println(count);
        }
    }


    public void problem3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        for (int j = 0; j < n; j++) {
//            System.out.println(recursion(nums[j]));
//        }

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Stack<Integer>());
            }
            map.get(nums[i]).push(i + 1);

            if (map.containsKey(1) && map.containsKey(2) && map.containsKey(3) && map.containsKey(4)
                    && map.containsKey(5) &&
                    !map.get(1).empty() && !map.get(2).empty() && !map.get(3).empty()
                    && !map.get(4).empty() && !map.get(5).empty()) {
                System.out.println(map.get(1).pop() + " " + map.get(2).pop() + " " + map.get(3).pop() +
                        " " + map.get(4).pop() + " " + map.get(5).pop());
            } else {
                System.out.println(-1);
            }
        }
    }
}
