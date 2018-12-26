package com.github.leetcode.easy;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class Leetcode709 {

    public String toLowerCase(String str) {
        if (str == null && str.length() == 0) {
            return null;
        } else {
            //直接用字符串函数
            return str.toLowerCase();
        }
    }
}
