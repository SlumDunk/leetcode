package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 12:26
 * @Description: Validate if a given string can be interpreted as a decimal number.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * <p>
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 * <p>
 * Numbers 0-9
 * Exponent - "e"
 * Positive/negative sign - "+"/"-"
 * Decimal point - "."
 * Of course, the context of these characters also matters in the input.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
public class Leetcode65 {
//    public static void main(String[] args) {
//        Leetcode65 leetcode65 = new Leetcode65();
//        System.out.println(leetcode65.isNumber("1 "));
//    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        } else {
            int len = s.length();
            int i = 0, e = len - 1;
            while (i <= e && Character.isWhitespace(s.charAt(i))) {
                i++;
            }
            if (i == len) {
                return false;
            }
            while (e >= i && Character.isWhitespace(s.charAt(e))) {
                e--;
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                i++;
            }
            //是否出现过数字
            boolean num = false;
            //是否出现过小数点
            boolean dot = false;
            //是否出现过指数e
            boolean exp = false;

            while (i <= e) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = true;
                } else if (c == '.') {
                    //指数的幂次不能是小数点
                    if (exp || dot) return false;
                    dot = true;
                } else if (c == 'e') {
                    //指数前面应该有基数 指数标签只能出现一次
                    if (exp || num == false) return false;
                    exp = true;
                    //重置数字标签
                    num = false;
                } else if (c == '+' || c == '-') {
                    if (s.charAt(i - 1) != 'e') return false;
                } else {
                    return false;
                }
                i++;
            }
            return num;
        }
    }


    public static void main(String[] args) {
        Leetcode65 leetcode65 = new Leetcode65();
        String s = "3.5e+3.5e+3.5";
        System.out.println(leetcode65.isNumber_(s));
    }

    /**
     * O(N)
     *
     * @param s
     * @return
     */
    public boolean isNumber_(String s) {
        if (s == null || s.length() == 0) {
            return false;
        } else {
            // numbers, '.', 'e/E'
            // before or after '.' there should be a number
            // before and after 'e/E' there should be a number, and after e, the number could not be float type
            // at the begining of str, can have '+' or '-'
            s = s.trim();
            if (s.length() == 0) {
                return false;
            }
            boolean num = false;
            boolean dot = false;
            boolean exp = false;

            int start = 0, end = s.length() - 1;
            if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                start++;
            }

            while (start <= end) {
                char c = s.charAt(start);
                if (Character.isDigit(c)) {
                    num = true;
                } else if (c == '.') {
                    if (dot || exp) return false;
                    dot = true;
                } else if (c == 'e') {
                    if (exp || !num) return false;
                    exp = true;
                    //reset the flag of num to indicate the number status after e
                    num = false;
                } else {
                    if ((c == '+' || c == '-') && s.charAt(start - 1) == 'e') {

                    } else {
                        return false;
                    }
                }
                start++;
            }
            //just one '.'
            return num;
        }
    }
}
