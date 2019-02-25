package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 16:55
 * @Description: Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.
 * <p>
 * A subsequence of a string S is obtained by deleting 0 or more characters from S.
 * <p>
 * A sequence is palindromic if it is equal to the sequence reversed.
 * <p>
 * Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.
 * <p>
 * Example 1:
 * Input:
 * S = 'bccb'
 * Output: 6
 * Explanation:
 * The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 * Note that 'bcb' is counted only once, even though it occurs twice.
 * Example 2:
 * Input:
 * S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * Output: 104860361
 * Explanation:
 * There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 * Note:
 * <p>
 * The length of S will be in the range [1, 1000].
 * Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
 */
public class Leetcode730 {
    public int countPalindromicSubsequences(String S) {
        int MOD = (int) (1e9 + 7);
        if (S == null || S.length() == 0) {
            return 0;
        } else {
            int len = S.length();
            int[][] dp = new int[len][len];
            for (int l = 1; l <= len; l++) {
                for (int i = 0; i + l - 1 < len; i++) {
                    int j = i + l - 1;
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (S.charAt(i) != S.charAt(j)) {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    } else {
                        int left = i + 1;
                        int right = j - 1;
                        while (left <= right && S.charAt(left) != S.charAt(i)) left++;
                        while (left <= right && S.charAt(right) != S.charAt(i)) right--;
                        if (left == right) {//中间一个重复
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                        } else if (left > right) {//没重复
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                        } else {//中间两个重复
                            dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                        }
                    }
                    if (dp[i][j] < 0) {
                        //overflow
                        dp[i][j] += MOD;
                    } else {
                        dp[i][j] %= MOD;
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
}
