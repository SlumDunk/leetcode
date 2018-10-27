package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 14:05
 * @Description: Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2+1"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 */
public class Leetcode227 {

    public static void main(String[] args) {
        Leetcode227 leetcode227 = new Leetcode227();
        System.out.println(leetcode227.calculate("3+2*2"));
    }

    public int calculate(String s) {
        int len;
        if (s == null || (len = s.length()) == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        // sign记录本次数字之前的上一个运算符，初始值为'+'，
        char sign = '+';
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 先乘除后加减
            if ((!Character.isDigit(s.charAt(i))
                    // 非空格
                    && ' ' != s.charAt(i))
                    // 到达字符串结束处，需要计算最后一次结果
                    || i == len - 1) {
                // 加减不计算结果，直接压入栈，运算符优先级
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                // 乘除从栈中弹出一个数字计算结果，在压入栈
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
