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
        leetcode772.calculate("1-(-7)");
    }

    static final Set<Character> opSet = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public int calculate(String s) {
        if (s == null) return 0;
        int n = s.length();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        char prevChar = '$'; // deal with cases that expr starts with '-1' '+2' or  has '(-3)' or (+3)

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
                operators.pop(); // remove '('
            } else if (opSet.contains(ch)) {
                while (!operators.isEmpty() && hasHighPriority(operators.peek(), ch)) {
                    calculate(operands, operators);
                }
                //通过比较前一字符来解决边界条件
                if ((prevChar == '$' || prevChar == '(') && (ch == '+' || ch == '-')) { // "-1*(-2)+(-3)"
                    operands.push(0);
                }
                operators.push(ch);

            }
            prevChar = ch; // for dealing with the case that ( followed with +/-
        }
        while (!operators.isEmpty()) {
            calculate(operands, operators);
        }
        return operands.pop();
    }

    static void calculate(Stack<Integer> operands, Stack<Character> operators) {
        int y = operands.pop();
        int x = operands.pop();
        operands.push(eval(x, y, operators.pop()));
    }

    static int eval(int x, int y, char op) {
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

    /**
     * 如果x的优先级>=y return true, 否则 return false
     *
     * @param x
     * @param y
     * @return
     */
    static boolean hasHighPriority(char x, char y) {
        //为括号
        if (x == '(' || x == ')' || y == '(' || y == ')') return false;
        //x为乘除
        if (x == '*' || x == '/') return true;
        //x为加减， y为乘除
        if (y == '*' || y == '/') return false;
        //都为加减
        return true;
    }
}
