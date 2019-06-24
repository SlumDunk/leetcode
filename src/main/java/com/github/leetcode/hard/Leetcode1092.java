package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 10:28
 * @Description: Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  If multiple answers exist, you may return any of them.
 * <p>
 * (A string S is a subsequence of string T if deleting some number of characters from T (possibly 0, and the characters are chosen anywhere from T) results in the string S.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "abac", str2 = "cab"
 * Output: "cabac"
 * Explanation:
 * str1 = "abac" is a substring of "cabac" because we can delete the first "c".
 * str2 = "cab" is a substring of "cabac" because we can delete the last "ac".
 * The answer provided is the shortest such string that satisfies these properties.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of lowercase English letters.
 */
public class Leetcode1092 {
    /**
     * 同求最长公共子序列
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] cs1 = str1.toCharArray();
        char[] cs2 = str2.toCharArray();

        // build the minimum length matrix for all sub-problems
        // dp[L1][L2] means minimum length of the substring for str1's prefix of length L1 and str2's prefix of length L2
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];
        for (int i = 0; i <= cs2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= cs1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                if (cs2[j - 1] == cs1[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        //从后往前推
        StringBuilder sb = new StringBuilder();
        int i1 = cs1.length;
        int i2 = cs2.length;
        while (i1 != 0 || i2 != 0) {
            if (i1 == 0) {
                sb.append(cs2[i2 - 1]);
                i2--;
                continue;
            }
            if (i2 == 0) {
                sb.append(cs1[i1 - 1]);
                i1--;
                continue;
            }
            if (cs1[i1 - 1] == cs2[i2 - 1]) {
                sb.append(cs1[i1 - 1]);
                i1--;
                i2--;
            } else if (dp[i1 - 1][i2] < dp[i1][i2 - 1]) {
                sb.append(cs1[i1 - 1]);
                i1--;
            } else {
                sb.append(cs2[i2 - 1]);
                i2--;
            }
        }
        return sb.reverse().toString();
    }
}
