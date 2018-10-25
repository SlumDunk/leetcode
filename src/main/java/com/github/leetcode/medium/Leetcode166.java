package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:52
 * @Description: Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 */
public class Leetcode166 {
    public static void main(String[] args) {
        Leetcode166 leetcode166 = new Leetcode166();
        leetcode166.fractionToDecimal(2, 3);
    }

    /**
     * 实现除法运算，结果返回为String类型的浮点数。
     * 必须要考虑的就是循环小数，当余数跟之前重复的时候就出现了循环小数
     * 可以根据这个来设计我们的算法
     */
    public String fractionToDecimal(int numerator, int denominator) {

        /**首先考虑除数为0，被除数为0的特殊情况*/
        if (numerator == 0) return "0";
        if (denominator == 0) return String.valueOf(Integer.MAX_VALUE);

        /**其次考虑两个数的符号不一致的情况*/
        String res = new String();
        if ((numerator < 0) ^ (denominator < 0))
            res = res + "-";

        /**考虑到Int类型为-2^32的溢出，所以转化为long，一定要先转换再求绝对值
         * 既然已经考虑了符号，就可以直接转为绝对值**/
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        /**区别整数部分和小数部分*/
        long ren = num / den;
        long rem = num % den;
        res = res + String.valueOf(ren);

        /**没有小数部分，直接返回**/
        if (rem == 0) return res;


        res += '.';
        /**采用map来存储余数，以及该余数对应的小数的位置，这样方便我们为循环小数打括号*/
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int beg = res.length();
        while (rem > 0) {
            rem = rem * 10;
            ren = rem / den;
            /**如果出现重复，需要截取出循环的部分打括号**/
            if (map.containsKey(rem)) {
                /**循环前**/
                String part1 = res.substring(0, map.get(rem));
                /** 循环后*/
                String part2 = res.substring(map.get(rem));
                res = part1 + "(" + part2 + ")";
                break;
            } else {
                res += String.valueOf(ren);
                map.put(rem, beg);
            }
            /**更新位置计数和余数**/
            beg++;
            rem = rem % den;

        }

        return res;

    }

}
