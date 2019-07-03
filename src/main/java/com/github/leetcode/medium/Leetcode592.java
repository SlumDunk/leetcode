package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 22:20
 * @Description: Given a string representing an expression of fraction addition and subtraction, you need to return the calculation result in string format. The final result should be irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of fraction that has denominator 1. So in this case, 2 should be converted to 2/1.
 * <p>
 * Example 1:
 * Input:"-1/2+1/2"
 * Output: "0/1"
 * Example 2:
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 * Example 3:
 * Input:"1/3-1/2"
 * Output: "-1/6"
 * Example 4:
 * Input:"5/3+1/3"
 * Output: "2/1"
 * Note:
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
 * Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 */
public class Leetcode592 {
    public String fractionAddition(String expression) {
        //记录分子的sum和分母sum
        int numerator = 0, denominator = 0;
        int num = 0;
        // 记录是正还是负
        boolean positive = true;

        // 当前分子和分母
        int curr_nume = 0, curr_deno = 0;
        for (int i = 0; i <= expression.length(); i++) {
            //遍历完字符串或者是遇到符号字符 处理前面的分母
            if (i == expression.length() || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                curr_deno = num;
                num = 0;

                if (denominator != 0) {//已有的分母不为0
                    int lcm = lcm(curr_deno, denominator);
                    numerator *= (lcm / denominator);
                    curr_nume *= (lcm / curr_deno);
                    numerator = positive ? numerator + curr_nume : numerator - curr_nume;
                    denominator = lcm;
                } else {
                    numerator = positive ? curr_nume : -curr_nume;
                    denominator = curr_deno;
                }
                if (i < expression.length()) positive = expression.charAt(i) == '+' ? true : false;
            } else if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                num = num * 10 + (expression.charAt(i) - '0');
                // Store num into current numerator
            else if (expression.charAt(i) == '/') {
                curr_nume = num;
                num = 0;
            }
        }

        if (numerator == 0) return "0/1";
            // Simplify the numerator and denominator using Math properties
            // e.g. 4/6 -> 2/3
        else {
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            return (numerator / gcd + "") + "/" + (denominator / gcd + "");
        }

    }

    /**
     * 求最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        if (a == 0) return b;
        else if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
