package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/22/18 15:34
 * @Description: Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Leetcode7 {
    public int reverse(int x) {
        //注意数字溢出
        int flag = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int tmp = 0;
        int result = 0;
        while (x > 0) {
            if ((Integer.MAX_VALUE - x % 10) / 10 < result) return 0;//避免溢出
            //获取低位
            tmp = x % 10;
            result = result * 10 + tmp;
            x = x / 10;
        }
        return flag * result;
    }
}
