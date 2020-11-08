package com.github.leetcode.easy;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 12/25/18 15:54
 * @Description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class Leetcode20 {
    /**
     * O(n)
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //利用堆栈来做，左边括号进栈，遇到右括号出栈，不配对返回false
        Stack<Character> stack = new Stack<Character>();
        for (char value : s.toCharArray()) {
            if ('(' == value || '[' == value || '{' == value) {
                stack.push(value);
            } else {
                if (stack.isEmpty()) {//栈为空，直接返回false
                    return false;
                } else {
                    char left = stack.pop();
                    if (!isValid(left, value)) {//判断是否配对
                        return false;
                    }
                }
            }
        }
        //还有没配对成功的
        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isValid(char left, char right) {
        return ('(' == left && right == ')') || ('[' == left && right == ']') || ('{' == left && right == '}');
    }
}
