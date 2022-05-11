package com.yore.nowcoder;

/**
 * @author Yore
 * @date 2022/5/11 16:36
 * @description
 */
public class BM62 {
    public int Fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci_2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
