package com.github.leetcode.hard;

/**
 * Given a string s and an integer k, return true if s is a k-palindrome.
 * <p>
 * A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcdeca", k = 2
 * Output: true
 * Explanation: Remove 'b' and 'e' characters.
 * Example 2:
 * <p>
 * Input: s = "abbababa", k = 1
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of only lowercase English letters.
 * 1 <= k <= s.length
 */
public class Leetcode1216 {
    /**
     * 找最长的回文子序列
     *
     * @param s
     * @param k
     * @return
     */
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int end = 0; end < n; end++) {
            // 从后往前推
            for (int start = end - 1; start >= 0; start--) {
                if (s.charAt(end) == s.charAt(start)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return (n - dp[0][n - 1]) <= k;
    }
}
