package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 15:47
 * @Description: Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
public class Leetcode856 {
    public int scoreOfParentheses(String S) {
        //(()(()))->(1(1))->(12)->(3)->6
        Stack<String> stack = new Stack<>();
        int ans = 0;
        // Solving for the whole string using stack
        for (char cc : S.toCharArray()) {
            // If opening bracket, just push it.
            if (cc == '(') {
                stack.push(cc + "");
            } else {
                // If closing bracket, then depending upon the 'type' compute sum between braces,
                // and push the new result to the stack
                if (cc == ')') {
                    int sum = 0;
                    while (stack.size() > 0 && !stack.peek().equals("(")) {
                        sum += (Integer.valueOf(stack.pop()));
                    }
                    stack.pop(); // remove the opening bracket now
                    if (sum == 0) {
                        stack.push("1");
                    } else {
                        stack.push(String.valueOf(2 * sum));
                    }
                }
            }
        }
        // Since we may have many expressions : Eg -> ()()(())
        while (stack.size() > 0) {
            ans += Integer.valueOf(stack.pop());
        }
        return ans;
    }
}
