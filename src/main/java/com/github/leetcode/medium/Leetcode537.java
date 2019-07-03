package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 21:30
 * @Description: Given two strings representing two complex numbers.
 * <p>
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * <p>
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * <p>
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
 */
public class Leetcode537 {
    public String complexNumberMultiply(String a, String b) {
        int i = a.indexOf("+");
        int m = a.indexOf("i");

        int j = b.indexOf("+");
        int n = b.indexOf("i");

        //a的实数部分
        int a1 = Integer.parseInt(a.substring(0, i));
        //a的虚数系数部分
        int a2 = Integer.parseInt(a.substring(i + 1, m));

        //b的实数部分
        int b1 = Integer.parseInt(b.substring(0, j));
        //b的虚数系数部分
        int b2 = Integer.parseInt(b.substring(j + 1, n));

        int c1 = a1 * b1 - (a2 * b2);

        int c2 = a1 * b2 + b1 * a2;

        String result = Integer.toString(c1) + "+" + Integer.toString(c2) + "i";

        return result;
    }
}
