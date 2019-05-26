package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 16:02
 * @Description: Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */
public class Leetcode678 {
    public boolean checkValidString(String s) {
        //强制匹配
        int min_op = 0;
        //最多匹配
        int max_op = 0;
        for (char c :
                s.toCharArray()) {
            if (c == '(') {
                ++min_op;
            } else {
                --min_op;
            }

            if (c != ')') {
                ++max_op;
            } else {
                --max_op;
            }

            if (max_op < 0) return false;
            min_op = Math.max(0, min_op);
        }
        return min_op == 0;
    }
}
