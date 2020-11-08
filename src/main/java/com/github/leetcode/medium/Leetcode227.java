package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
        //记录正在处理的数字
        int num = 0;
        //第一次运算任务
        char sign = '+';
        for (int i = 0; i < len; i++) {
            //多位数
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            // 遇到新的计算任务，先解决现有的运算任务 先乘除后加减
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
                //下一次运算任务
                sign = s.charAt(i);
                //下一个参加运算的数字
                num = 0;
            }
        }

        //栈里头的数字出栈，求和即可得到结果
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }


    final Set<Character> opSet = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public int calculate_(String s) {
        if (s == null) return 0;
        int n = s.length();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        char prevChar = '$';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;

            if (Character.isDigit(ch)) {
                int val = ch - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    val = val * 10 + (s.charAt(i) - '0');
                }
                operands.push(val);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peek() != '(') {
                    calculate(operands, operators);
                }
                operators.pop();
            } else if (opSet.contains(ch)) {
                while (!operators.isEmpty() && hasHighPriority(operators.peek(), ch)) {
                    calculate(operands, operators);
                }
                if ((prevChar == '$' || prevChar == '(') && (ch == '+' || ch == '-')) {
                    operands.push(0);
                }
                operators.push(ch);
            }
            prevChar = ch;
        }

        while (!operators.isEmpty()) {
            calculate(operands, operators);
        }
        return operands.pop();
    }

    private boolean hasHighPriority(char x, char y) {
        if (x == '(' || x == ')' || y == '(' || y == ')') {
            return false;
        }

        if (x == '*' || x == '/') return true;

        if (y == '*' || y == '/') return false;

        return true;
    }

    private void calculate(Stack<Integer> operands, Stack<Character> operators) {
        int y = operands.pop();
        int x = operands.pop();

        operands.push(eval(x, y, operators.pop()));
    }

    private int eval(int x, int y, char op) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return 0;
    }
}
