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
        //第一次出现的位置和最后一次出现的位置是否一致
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
