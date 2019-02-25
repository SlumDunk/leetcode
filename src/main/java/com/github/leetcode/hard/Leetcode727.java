package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 10:12
 * @Description: Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 * <p>
 * <p>
 * Note:
 * <p>
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 */
public class Leetcode727 {
    public String minWindow(String S, String T) {
        int index = 0;
        int minLeft = -1;
        int minRight = -1;
        int minLen = S.length();
        while (index <= S.length() - T.length()) {
            int tIndex = 0;
            int left = -1;
            int right = -1;
            for (int i = index; i < S.length(); i++) {
                if (S.charAt(i) == T.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == 1 && left == -1) {
                    left = i;
                    index = left + 1;
                }
                if (tIndex == T.length()) {
                    right = i;
                    break;
                }
            }
            if (left == -1 || right == -1) {
                break;
            }
            if (right - left + 1 < minLen) {
                minLeft = left;
                minRight = right;
                minLen = right - left + 1;
            }
        }

        if (minLeft == -1 || minRight == -1) {
            return "";
        }

        return S.substring(minLeft, minRight + 1);
    }

    /**
     * dp[i][j] stores the starting index of the substring where T has length i and S has length j.
     * <p>
     * So dp[i][j would be:
     * if T[i - 1] == S[j - 1], this means we could borrow the start index from dp[i - 1][j - 1] to make the current substring valid;
     * else, we only need to borrow the start index from dp[i][j - 1] which could either exist or not.
     * <p>
     * Finally, go through the last row to find the substring with min length and appears first.
     *
     * @param S
     * @param T 子串
     * @return
     */
    public String DPMinWindow(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0, minLen = n + 1;
        for (int i = 1; i <= n; i++) {
            if (dp[m][i] != 0) {
                if (i - dp[m][i] + 1 < minLen) {
                    start = dp[m][i] - 1;
                    minLen = i - dp[m][i] + 1;
                }
            }
        }

        return minLen == n + 1 ? "" : S.substring(start, start + minLen);
    }
}
