package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/13/19 17:40
 * @Description: Given a string s, cut s into some substrings such that every substring is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example
 * Given s = "aab",
 * <p>
 * Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.
 */
public class Lintcode108 {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            int len = s.length();
            boolean[][] isPalindrome = getIsPalindrome(s);
            //前i个字符最少需要经过多少次切割才能成为回文串
            int[] dp = new int[len + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = i - 1;
            }

            for (int i = 1; i <= len; i++) {
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j][i - 1]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[len];
        }
    }

    public boolean[][] getIsPalindrome(String s) {
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int length = 2; length < len; length++) {
            for (int start = 0; start + length < len; start++) {
                isPalindrome[start][start + length] = s.charAt(start) == s.charAt(start + length) && isPalindrome[start + 1][start + length - 1];
            }
        }
        return isPalindrome;
    }
}
