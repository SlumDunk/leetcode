package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 22:19
 * @Description: Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).
 * <p>
 * Note:
 * <p>
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 * Example 1:
 * <p>
 * Input: "T?2:3"
 * <p>
 * Output: "2"
 * <p>
 * Explanation: If true, then result is 2; otherwise result is 3.
 * Example 2:
 * <p>
 * Input: "F?1:T?4:5"
 * <p>
 * Output: "4"
 * <p>
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 * <p>
 * "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 * -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 * -> "4"                                    -> "4"
 * Example 3:
 * <p>
 * Input: "T?T?F:5:3"
 * <p>
 * Output: "F"
 * <p>
 * Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:
 * <p>
 * "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 * -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 * -> "F"                                    -> "F"
 */
public class Leetcode439 {
    /**
     * dfs
     *
     * @param expression
     * @return
     */
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        if (expression.length() == 1) {
            return expression;
        }

        char c = expression.charAt(0);
        int index = expression.indexOf("?") + 1;
        int count = 1;
        while (index < expression.length()) {
            if (expression.charAt(index) == '?') count++;
            else if (expression.charAt(index) == ':') count--;
            if (count == 0) break;
            index++;
        }
        if (c == 'T') {//index存储的是 : 的位置
            return parseTernary(expression.substring(2, index));
        }
        return parseTernary(expression.substring(index + 1));
    }
}
