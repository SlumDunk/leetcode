package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 16:33
 * @Description: A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0), followed by some number of '1's (also possibly 0.)
 * <p>
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * <p>
 * Return the minimum number of flips to make S monotone increasing.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * Example 2:
 * <p>
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 * Example 3:
 * <p>
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S only consists of '0' and '1' characters.
 */
public class Leetcode926 {
    public int minFlipsMonoIncr(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; ++i) {
            if (S.charAt(i - 1) == '0') {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
