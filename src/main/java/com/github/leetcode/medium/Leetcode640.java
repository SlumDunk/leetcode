package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 08:36
 * @Description: Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class Leetcode640 {
    public String solveEquation(String equation) {
        //存储x的系数
        int x = 0;
        //存储常数项
        int c = 0;
        int n = equation.length();
        String curr = "";
        //等式左右边
        int sign = 1;
        //正负
        int ps = 1;
        equation = equation + '+';
        for (int i = 0; i <= n; i++) {
            char now = equation.charAt(i);

            if (now == '+' || now == '-' || now == '=') {
                int m = curr.length();
                if (m != 0) {
                    if (curr.charAt(m - 1) == 'x') {//包含x的系数项
                        int coeff = 0;
                        if (m == 1)
                            coeff = 1;
                        else
                            coeff = Integer.parseInt(curr.substring(0, m - 1));
                        x = x + ps * sign * coeff;
                    } else {
                        int coeff = Integer.parseInt(curr);
                        c = c + ps * sign * coeff;
                    }
                }
                curr = "";
            } else {
                curr = curr + now;
            }
            if (now == '=') {//等式右侧 移到左侧
                sign = -1;
                ps = 1;
            }
            if (now == '+') {
                ps = 1;
            }
            if (now == '-') {
                ps = -1;
            }

        }

        if (x == 0 && c != 0)
            return "No solution";
        if (x == 0 && c == 0)
            return "Infinite solutions";
        c = c / x;
        return "x=" + String.valueOf(c * (-1));
    }
}
