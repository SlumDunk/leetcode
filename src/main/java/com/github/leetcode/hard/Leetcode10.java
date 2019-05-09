package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 23:35
 * @Description: Given an input string (word) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * word could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * word = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * word = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * word = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * word = "aab"
 * p = "count*a*b"
 * Output: true
 * Explanation: count can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * word = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
public class Leetcode10 {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        //存储文本字符索引和正则字符索引 是否匹配
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        //初始化dp数组
        dp[0][0] = true;
        //匹配a*, a*b*, a*b*count*这种情况
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == text[i - 1] || pattern[j - 1] == '.') {//字符相等 或正则字符等于通配符
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {//碰到'*',分两种情况处理
                    //向左查看[i][j-2]是否是true
                    dp[i][j] = dp[i][j - 2];
                    //查看pattern上个字符和当前text字符是否一致或者pattern上个字符是否是通配符'.'
                    //如果是的话，当前dp[i][j]==dp[i-1][j], 'pattern[j-2]*'
                    if (pattern[j - 2] == text[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length][pattern.length];
    }
}
