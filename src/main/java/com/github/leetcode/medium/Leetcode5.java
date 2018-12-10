package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 13:16
 * @Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class Leetcode5 {
    public static void main(String[] args) {
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // i is the center of the substring
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            // i,i+1 is the center of the substring
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    private String helper(String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }

    public String dpLongestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        int len = s.length();
        int start = 0, end = 0;
        int maxLength = 0;
        int matrix[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            matrix[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (i + 1 <= j - 1 && matrix[i + 1][j - 1] > 0) {
                        matrix[i][j] = matrix[i + 1][j - 1] + 2;
                    } else if (i + 1 == j) {
                        matrix[i][j] = 2;
                    }
                    if (matrix[i][j] > maxLength) {
                        start = i;
                        end = j;
                        maxLength = matrix[i][j];
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
