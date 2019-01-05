package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/5/19 11:37
 * @Description: Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 * <p>
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 * <p>
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */
public class Leetcode44 {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        int writeIndex = 0;
        boolean isFirst = true;
        //把连续的多个*替换成一个*
        //e.g a**b***c--> a*b*c
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst == true) {//第一次出现
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                //复位
                isFirst = true;
            }
        }

        //存储文本字符索引和正则字符索引 是否匹配
        boolean dp[][] = new boolean[s.length() + 1][writeIndex + 1];
        //初始化dp数组
        dp[0][0] = true;
        if (writeIndex > 0 && pattern[0] == '*') {//首位出现，能匹配空格
            dp[0][1] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == text[i - 1] || pattern[j - 1] == '?') {//字符相等 或正则字符等于通配符
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {//碰到'*',分两种情况处理
                    //*起作用匹配了字符,i这是作为*匹配的字符串的一部分 或者 不起作用，不匹配字符
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length][writeIndex];
    }
}
