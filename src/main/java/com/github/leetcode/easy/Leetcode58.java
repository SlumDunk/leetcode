package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/25/18 16:57
 * @Description: Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 */
public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        //空串
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        //字符串切成数组
        String[] array = s.split(" ");
        return array[array.length - 1].length();
    }
}
