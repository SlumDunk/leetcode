package com.github.leetcode.hard;

/**
 * You are given a string s containing lowercase letters and an integer k. You need to :
 * <p>
 * First, change some characters of s to other lowercase English letters.
 * Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
 * Return the minimal number of characters that you need to change to divide the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", k = 2
 * Output: 1
 * Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
 * Example 2:
 * <p>
 * Input: s = "aabbc", k = 3
 * Output: 0
 * Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
 * Example 3:
 * <p>
 * Input: s = "leetcode", k = 8
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= k <= s.length <= 100.
 * s only contains lowercase English letters.
 */
public class Leetcode1278 {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        // [i,j] 子串形成 回文串的成本
        int[][] cost = new int[n][n];
        // 回文串长度
        for (int l = 2; l <= n; l++) {
            for (int i = 0, j = l - 1; j < n; i++, j++) {
                cost[i][j] = cost[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }
        // [0,n]字符串切割成k个回文串的最小成本
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][1] = cost[0][i];
            //[0,i] 切成 j 个回文串
            for (int j = 2; j <= k; j++) {
                // 切的位置为 l, [0,l] 构成 j-1 个回文串， [l+1,i] 构成一个回文串
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + cost[l + 1][i]);
                }
            }
        }
        return dp[n - 1][k];
    }
}
