package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 22:16
 * @Description: Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].
 * <p>
 * Some examples:
 * <p>
 * "1 + 1" = 2
 * " 6-4 / 2 " = 4
 * "2*(5+5*2)/3+(6/2+8)" = 21
 * "(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 * <p>
 * <p>
 * Note: Do not use the eval built-in library function.
 */
public class Leetcode772 {
    public static void main(String[] args) {
        Leetcode772 leetcode772 = new Leetcode772();
        leetcode772.calculate("2*(5+5*2)/3+(6/2+8)");
    }

    public int calculate(String s) {
        if (s == null) {
            return 0;
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c :
                s.toCharArray()) {
            queue.offer(c);
        }
        queue.offer('+');
        return cal(queue);

    }

    private int cal(Queue<Character> queue) {
        char sign = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {//看成一个独立的子问题
                num = cal(queue);
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                num = 0;
                sign = c;
                if (c == ')') {
                    break;
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    /**
     * @param factor1
     * @param factor2
     * @param operator
     * @return
     */
    private String calcluate(long factor1, long factor2, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf(factor1 + factor2);
            case "-":
                return String.valueOf(factor1 - factor2);
            case "*":
                return String.valueOf(factor1 * factor2);
            case "/":
                return String.valueOf(factor1 / factor2);
            default:
                return "";
        }

    }

    /**
     * 将字符串转换为list,仅包含数字字符串和操作符字符串
     *
     * @param s
     * @return
     */
    private List<String> tokenize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        s = sb.toString();
        Set<Character> ops = new HashSet<>();
        Collections.addAll(ops, '+', '-', '*', '/', '(', ')');
        List<String> res = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ops.contains(s.charAt(i))) {
                res.add(String.valueOf(s.charAt(i)));
            } else {
                start = i;
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                res.add(s.substring(start, i + 1));
            }
        }
        return res;
    }
}
