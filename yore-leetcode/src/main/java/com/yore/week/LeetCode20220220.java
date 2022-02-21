package com.yore.week;

import com.yore.base.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yore
 * @date 2022/2/20 10:29
 * @description
 */
public class LeetCode20220220 {


    public int countEven(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            int a = i;
            int sum = 0;
            while (a != 0) {
                sum += (a % 10);
                a /= 10;
            }
            if (sum % 2 == 0) {
                count++;
            }
        }
        return count;
    }


    public ListNode mergeNodes(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = head;
        ListNode q = pre;
        while (p != null) {
            if (p.val == 0) {
                p = p.next;
                continue;
            }
            int count = 0;
            while (p.val != 0) {
                count += p.val;
                p = p.next;
            }
            q.next = new ListNode(count);
            q = q.next;
        }
        return pre.next;
    }


    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        int l = s.length();
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder("");
        int c = 0;
        int p = 25;
        int repeat = 0;
        while (c < l) {
            int i = p;
            while (i >= 0 && count[i] == 0) {
                i--;
            }
            while (i >= 0 && count[i] != 0 && repeat < repeatLimit) {
                sb.append((char) ('a' + i));
                count[i]--;
                repeat++;
                c++;
                p = i;
            }
            int j = i - 1;
            for (; j >= 0; j--) {
                if (count[j] != 0) {
                    sb.append((char) ('a' + j));
                    count[j]--;
                    c++;
                    break;
                }
            }
            if (j < 0) {
                break;
            }
            if (i >= 0 && j >= 0 && count[i] == 0 && count[j] > 0) {
                repeat = 1;
            } else {
                repeat = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(repeatLimitedString("cczazcc", 3));
//        System.out.println(repeatLimitedString("aababab", 2));
//        System.out.println(gcd(3, 6));
//        System.out.println(gcd(12, 2));
//        System.out.println(gcd(3, 5));
        System.out.println(coutPairs2(new int[]{1,2,3,4,5},2));
    }

    public static long coutPairs(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long multi = (long) nums[i] * (long) nums[j];
                if (multi % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    final static int mx = 100001;
    static ArrayList<ArrayList<Integer>> divisors = new ArrayList<>(mx);

    static {
        for (int i = 0; i < mx; i++) {
            divisors.add(new ArrayList<>());
        }
        for (int i = 1; i < mx; ++i) { // 预处理每个数的所有因子，时间复杂度 O(MlogM)，M=1e5
            for (int j = i; j < mx; j += i) {
                divisors.get(j).add(i);
            }
        }
    }

    public static long coutPairs2(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            ans += countMap.getOrDefault(k / gcd(num, k), 0);
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                    if (i * i <= num) {
                        countMap.put(num / i, countMap.getOrDefault(num / i, 0) + 1);
                    }
                }
            }
        }
        return ans;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
