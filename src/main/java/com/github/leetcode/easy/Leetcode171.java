package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 20:54
 * @Description: Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class Leetcode171 {
    public static void main(String[] args) {
        Leetcode171 leetcode171=new Leetcode171();
        leetcode171.titleToNumber("AA");
    }
    public int titleToNumber(String s) {
        //26进制，从高位到低位
        int len = s.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            result = (s.charAt(i) - 'A' + 1) + result * 26;
        }
        return result;
    }
}
