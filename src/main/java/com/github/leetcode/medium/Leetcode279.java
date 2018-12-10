package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 21:36
 * @Description: Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Leetcode279 {
    public static void main(String[] args) {
        Leetcode279 leetcode279 = new Leetcode279();
        leetcode279.numSquares(12);
    }

    public int numSquares(int n) {
//        int[] res = new int[n + 1];
//        res[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            int minNum = Integer.MAX_VALUE;
//            for (int base = 1; i - base * base >= 0; base++) {
//                minNum = Math.min(res[i - base * base], minNum);
//            }
//            res[i] = minNum + 1;
//        }
//        return res[n];
        //如果自己能开方，那么他的值是1， 如果不能开方，那么他的值是dp[num-j*j]+1, dp[]数组存储最小的中间结果
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                int minNum = dp[i - j*j] + 1;
                dp[i] = Math.min(dp[i], minNum);
            }

        }
        return dp[n];

    }
}
