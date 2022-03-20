package com.yore.week;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yore
 * @date 2022/3/20 10:27
 * @description
 */
public class LeetCode20220320 {
    public static void main(String[] args) {
        LeetCode20220320 l = new LeetCode20220320();
//        System.out.println(l.countHillValley(new int[]{2,4,1,1,6,5}));
//        System.out.println(l.countCollisions("LLRR"));
//        System.out.println(l.maximumBobPoints(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0}));

//        System.out.println(l.maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2}));
        System.out.println(l.maximumBobPoints(89, new int[]{3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5}));
    }

    public int countHillValley(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (n <= 2) {
            return 0;
        }
        for (int i = 1; i < n - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && nums[left] == nums[i]) {
                left--;
            }
            while (right < n && nums[right] == nums[i]) {
                right++;
            }
            if (left >= 0 && nums[i] > nums[left] && nums[i] > nums[right] && nums[i] != nums[i - 1]) {
                count++;
            } else if (right < n && nums[i] < nums[left] && nums[i] < nums[right] && nums[i] != nums[i - 1]) {
                count++;
            }

        }
        return count;
    }

    public int countCollisions(String directions) {
        int count = 0;
        int n = directions.length();
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if (queue.isEmpty() || c == 'R') {
                queue.offerLast(c);
            } else if (c == 'S') {
                while (!queue.isEmpty() && queue.peekLast() == 'R') {
                    count++;
                    queue.pollLast();
                }
                queue.offerLast(c);
            } else if (c == 'L') {
                char ch = queue.peekLast();
                if (ch == 'S') {
                    count++;
                } else if (ch == 'R') {
                    count += 2;
                    queue.pollLast();
                    while (!queue.isEmpty() && queue.peekLast() == 'R') {
                        count++;
                        queue.pollLast();
                    }
                    queue.offerLast('S');
                }
            }
        }
        return count;
    }

    public int countCollisions2(String directions) {
        int n = directions.length();
        int left = 0;
        while (left < n && directions.charAt(left) == 'L') {
            left++;
        }
        int right = n - 1;
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }
        String str = directions.substring(left, right + 1);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'S') {
                count++;
            }
        }
        return count;
    }


    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int[] result = new int[n];
        int[][] dp = new int[n + 1][numArrows + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= numArrows; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j > aliceArrows[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - aliceArrows[i] - 1] + i);
                }
            }
        }
        int j = numArrows;
        for (int i = 0; i < n; i++) {
            if (dp[i][j] == dp[i + 1][j]) {
                result[i] = 0;
            } else {
                j -= (aliceArrows[i] + 1);
                result[i] = aliceArrows[i] + 1;
            }
        }
        if (j > 0) {
            result[0] = j;
        }
        return result;
    }

}
