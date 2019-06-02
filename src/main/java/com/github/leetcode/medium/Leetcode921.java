package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 18:15
 * @Description: Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "())"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "((("
 * Output: 3
 * Example 3:
 * <p>
 * Input: "()"
 * Output: 0
 * Example 4:
 * <p>
 * Input: "()))(("
 * Output: 4
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 1000
 * S only consists of '(' and ')' characters.
 */
public class Leetcode921 {
    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int openLeft = 0;
        int res = 0;
        for (char c :
                S.toCharArray()) {
            if (c == '(') openLeft++;
            else if (c == ')') openLeft--;
            if (openLeft == -1) {
                res++;
                openLeft++;
            }
        }
        res += openLeft;
        return res;
    }
}
