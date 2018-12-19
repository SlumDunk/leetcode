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
        leetcode166.fractionToDecimal(-1, -2147483648);
    }

    /**
     * 实现除法运算，结果返回为String类型的浮点数。
     * 必须要考虑的就是循环小数，当余数跟之前重复的时候就出现了循环小数
     * 可以根据这个来设计我们的算法
     */
    public String fractionToDecimal(int numerator, int denominator) {
        //考虑除数为0 和 被除数为0的情况
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return String.valueOf(Integer.MAX_VALUE);
        }
        String res = "";
        //考虑异号情况
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            res = res + "-";
        }
        //不需要考虑正负号了，将int 类型转为long 型
        long num = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        //区别整数部分和小数部分
        long ren = num / denom;
        long rem = num % denom;

        //整数部分先拼接上
        res = res + ren;
        if (rem > 0) {//有小数
            res = res + ".";
            int index = res.length();//循环开始位置
            //记录余数和其开始的位置
            Map<Long, Integer> map = new HashMap<>();
            //循环求出小数，或者是指导余数出现循环小数的情况
            while (rem > 0) {
                num = rem * 10;//余数扩大10倍
                ren = num / denom;
                if (map.containsKey(num)) {//余数出现过
                    //将原有的结果拆分非循环部分和循环部分
                    String part1 = res.substring(0, map.get(num));
                    String part2 = res.substring(map.get(num));
                    res = part1 + "(" + part2 + ")";
                    return res;
                } else {
                    res += String.valueOf(ren);
                    map.put(num, index);
                }
                index++;
                rem = num % denom;
            }

        }

        return res;
    }

}
