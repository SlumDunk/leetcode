package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/20/18 10:23
 * @Description: Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test cases.
 */
public class Leetcode392 {
    public boolean isSubsequence(String s, String t) {
        if (t.length() < s.length()) return false;
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmpChar = s.charAt(i);
            prev = t.indexOf(tmpChar, prev);
            if (prev == -1) return false;
            prev++;
        }
        return true;
    }
}
