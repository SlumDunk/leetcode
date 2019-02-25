package com.github.leetcode.hard;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 2/21/19 08:29
 * @Description: Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class Leetcode32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        } else {
            Stack<Integer> stack = new Stack<Integer>();
            int maxLen = 0;
            //累计匹配的串的长度
            int accumulateLen = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (stack.isEmpty()) {//没有匹配的'('，中间发生了中断
                        accumulateLen = 0;
                    } else {//有可以匹配的')'
                        int matchedPos = stack.pop();
                        int matchedLen = i - matchedPos + 1;
                        if (stack.isEmpty()) {//栈为空时"()()"
                            accumulateLen += matchedLen;
                            matchedLen = accumulateLen;
                        } else {//一般情况
                            matchedLen = i - stack.peek();
                        }
                        maxLen = Math.max(maxLen, matchedLen);
                    }
                }
            }
            return maxLen;
        }
    }
}
