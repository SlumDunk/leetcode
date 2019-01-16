package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 14:36
 * @Description: Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example
 * For s1 = "aabcc", s2 = "dbbca"
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * Challenge
 * O(n2) time or better
 */
public class Lintcode29 {
    public static void main(String[] args) {
        Lintcode29 lintcode29 = new Lintcode29();
        lintcode29.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        } else {
            int m = s1.length();
            int n = s2.length();
            //s1的前i个字符和s2的前j个字符能否组成s3的前i+j个字符
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= m; i++) {
                dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
            }
            for (int i = 1; i <= n; i++) {
                dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                    if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
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
}
