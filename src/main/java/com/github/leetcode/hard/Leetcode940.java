package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 13:35
 * @Description: Given a string S, count the number of distinct, non-empty subsequences of S .
 * <p>
 * Since the result may be large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 7
 * Explanation: The 7 distinct subsequences are "a", "b", "c", "ab", "ac", "bc", and "abc".
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: 6
 * Explanation: The 6 distinct subsequences are "a", "b", "ab", "ba", "aa" and "aba".
 * Example 3:
 * <p>
 * Input: "aaa"
 * Output: 3
 * Explanation: The 3 distinct subsequences are "a", "aa" and "aaa".
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * S contains only lowercase letters.
 * 1 <= S.length <= 2000
 */
public class Leetcode940 {
    public int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int len = S.length();
        int[] dp = new int[len + 1];
        // 存储该字符最近一次出现的位置
        int[] last = new int[26];

        // 动态规划
        for (int i = 1; i <= len; i++) {
            // 获取当前字符
            int endDigit = S.charAt(i - 1) - 'a';
            dp[i] = 2 * dp[i - 1] % MOD;
            // it's value is only from [1,N] possib
            if (last[endDigit] > 0) { // can't add to it
                // 组合过一次了，得排除掉
                // which means in other words --> the number that can be double counted
                dp[i] -= dp[last[endDigit] - 1];
            } else { // 字符单独拎出来组成一个
                dp[i] = (dp[i] + 1) % MOD;
            }

            dp[i] %= MOD;
            // 更新最近一次出现的位置
            last[endDigit] = i;
        }

        // 溢出
        if (dp[len] < 0) dp[len] += MOD;
        return dp[len] % MOD;
    }
}
