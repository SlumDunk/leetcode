package com.github.leetcode.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: False
 * Example 3:
 * <p>
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class Leetcode459 {
    public static void main(String[] args) {
        Leetcode459 leetcode459 = new Leetcode459();
        leetcode459.repeatedSubstringPattern("abaababaab");
    }

    public boolean repeatedSubstringPattern(String s) {
        //如果是由重复的子串组成，那么两个原来的字符串拼接成新串
        //去头去尾还能包含原来的字符串
        String doubleStr = s + s;
        return doubleStr.substring(1, doubleStr.length() - 1).contains(s);
    }
}
