package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/14/19 08:01
 * @Description: Find the Nth number in Fibonacci sequence.
 * <p>
 * A Fibonacci sequence is defined as follow:
 * <p>
 * The first two numbers are 0 and 1.
 * The i th number is the sum of i-1 th number and i-2 th number.
 * The first ten numbers in Fibonacci sequence is:
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 * <p>
 * Example
 * Example 1:
 * Input:  1
 * Output: 0
 * <p>
 * Explanation:
 * return the first number in  Fibonacci sequence .
 * <p>
 * Example 2:
 * Input:  2
 * Output: 1
 * <p>
 * Explanation:
 * return the second number in  Fibonacci sequence .
 * <p>
 * Notice
 * The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.
 */
public class Lintcode366 {
    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
