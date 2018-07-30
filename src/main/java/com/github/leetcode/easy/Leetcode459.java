package com.github.leetcode.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: False
 * Example 3:
 * <p>
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Leetcode459 {
    public static void main(String[] args) {
        Leetcode459 leetcode459 = new Leetcode459();
        leetcode459.repeatedSubstringPattern("abaababaab");
    }

    public boolean repeatedSubstringPattern(String s) {
        int i = 1, j = 0, n = s.length();
        int[] dp = new int[n + 1];
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) dp[++i] = ++j;
            else if (j == 0) ++i;
            else j = dp[j];
        }
        if (dp[n] != 0 && (dp[n] % (n - dp[n]) == 0)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
