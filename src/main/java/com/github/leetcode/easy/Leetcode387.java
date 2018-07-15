package com.github.leetcode.easy;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class Leetcode387 {
    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.lastIndexOf(s.charAt(i)) == i && s.indexOf(s.charAt(i)) == i) {
                    return i;
                }
            }
            return -1;
        }
    }
}
