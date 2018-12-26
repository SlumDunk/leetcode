package com.github.leetcode.easy;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * <p>
 * Please note that the string does not contain any non-printable characters.
 * <p>
 * Example:
 * <p>
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class Leetcode434 {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                //第一个单词比较特殊，首字母前一个不是空格，剩下的单词首字母前一字符是空格
                if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                    res++;
                }
            }
            return res;
        }

    }
}

