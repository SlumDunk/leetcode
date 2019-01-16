package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 14:06
 * @Description: Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * Example
 * Given S = "rabbbit", T = "rabbit", return 3.
 * <p>
 * Challenge
 * Do it in O(n2) time and O(n) memory.
 * <p>
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 */
public class Lintcode118 {
    public static void main(String[] args) {
        Lintcode118 lintcode118 = new Lintcode118();
        lintcode118.numDistinct("rabbbit", "rabbit");
    }

    /*
   * @param : A string
   * @param : A string
   * @return: Count the number of distinct subsequences
   */
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return -1;
        }
        int m = S.length();
        int n = T.length();
        //S的前i个字符组成T的前j个字符的方式
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("" + dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m][n];
    }
}
