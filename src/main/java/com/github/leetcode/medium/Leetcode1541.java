package com.github.leetcode.medium;


import java.util.Stack;

/**
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
 * <p>
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * In other words, we treat '(' as openning parenthesis and '))' as closing parenthesis.
 * <p>
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * <p>
 * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 * <p>
 * Return the minimum number of insertions needed to make s balanced.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()))"
 * Output: 1
 * Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to to add one more ')' at the end of the string to be "(())))" which is balanced.
 * Example 2:
 * <p>
 * Input: s = "())"
 * Output: 0
 * Explanation: The string is already balanced.
 * Example 3:
 * <p>
 * Input: s = "))())("
 * Output: 3
 * Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 * Example 4:
 * <p>
 * Input: s = "(((((("
 * Output: 12
 * Explanation: Add 12 ')' to balance the string.
 * Example 5:
 * <p>
 * Input: s = ")))))))"
 * Output: 5
 * Explanation: Add 4 '(' at the beginning of the string and one ')' at the end. The string becomes "(((())))))))".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * s consists of '(' and ')' only.
 */
public class Leetcode1541 {
    public int minInsertions(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (i < s.length() - 1 && ch == ')' && s.charAt(i + 1) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {// 补个左括号
                    ans++;
                }
                i++;
            } else if (ch == ')') {
                if (!stack.isEmpty()) {// 补个右括号
                    stack.pop();
                    ans++;
                } else { // 补个左括号，补个右括号
                    ans += 2;
                }
            }
        }

        if (!stack.isEmpty()) {
            ans += 2 * stack.size();
        }

        return ans;
    }
}
