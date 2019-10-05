package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 10:47
 * @Description: Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * If there is no common subsequence, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        } else {
            char[] array1 = text1.toCharArray();
            char[] array2 = text2.toCharArray();
            int m = array1.length, n = array2.length;
            //text1 的前m个字符和text2的前n个字符的最长公共子串
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                dp[i][0] = 0;
            }

            for (int i = 0; i <= n; i++) {
                dp[0][i] = 0;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (array1[i - 1] == array2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }

            return dp[m][n];
        }
    }

    public int longestCommonSubsequence__(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (array1[i - 1] == array2[j - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
