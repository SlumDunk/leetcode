package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 09:30
 * @Description: Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 */
public class Leetcode87 {
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }
        //s1字符i开头，s2字符j开头，长度为len的字符串是否为爬山子序列
        boolean[][][] dp = new boolean[m][n][n + 1];
        int i, j, w, len;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }

        for (len = 2; len <= n; len++) {
            for (i = 0; i <= n - len; i++) {
                for (j = 0; j <= n - len; j++) {
                    for (w = 1; w < len; w++) {
                        //s1[i...i+w-1]=s2[j...j+w-1], s1[i+w...i+len-1]==s2=[j+w....j+len-1]
                        if (dp[i][j][w] && dp[i + w][j + w][len - w]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        //s1[i+w...i+len-1]=s2[j...j+len-w-1], s1[i...i+w-1]==s2=[j+len-w....j+len-1]
                        if (dp[i + w][j][len - w] && dp[i][j + len - w][w]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][n];
    }


    public boolean isScramble__(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }

        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        boolean[][][] dp = new boolean[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = array1[i] == array2[j];
            }
        }
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    dp[i][j][k] = false;
                    //切割点
                    for (int w = 1; w <= k - 1; w++) {
                        if (dp[i][j][w] == true && dp[i + w][j + w][k - w] == true) {
                            dp[i][j][k] = true;
                            break;
                        } else if (dp[i][j + k - w][w] == true && dp[i + w][j][k - w] == true) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][n];
    }
}
