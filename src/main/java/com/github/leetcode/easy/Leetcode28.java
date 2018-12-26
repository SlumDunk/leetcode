package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/24/18 17:33
 * @Description: Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */
public class Leetcode28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) {
            return 0;
        } else if (haystack.length() < needle.length()) {
            return -1;
        } else {
            //遍历字符串haystack
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                boolean success = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    return i;
                }
            }
            return -1;
        }
    }
}
