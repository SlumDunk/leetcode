package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 12:38
 * @Description: Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Example 1:
 * <p>
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation:
 * <p>
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * (The caret symbol ^ means the chosen letters)
 * <p>
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 * Example 2:
 * <p>
 * Input: S = "babgbag", T = "bag"
 * Output: 5
 * Explanation:
 * <p>
 * As shown below, there are 5 ways you can generate "bag" from S.
 * (The caret symbol ^ means the chosen letters)
 * <p>
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 * ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 */
public class Leetcode115 {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int m = s.length();
        int n = t.length();
        //s的前i个字符包括t的前j个字符的方式
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public int numDistinct__(String s, String t) {
        int m = s.length();
        int n = t.length();

        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        //t的前i个字符在s的前j个字符中出现的次数
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (array1[j - 1] == array2[i - 1]) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                    dp[i][j] += dp[i][j - 1];

                }
            }
        }

        return dp[n][m];
    }
}
