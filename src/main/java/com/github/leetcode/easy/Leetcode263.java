package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/23/18 10:47
 * @Description: Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 * <p>
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 * <p>
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
public class Leetcode263 {
    public boolean isUgly(int num) {
        //因子是由2，3，5组成的数字
        if (num == 0) {
            return false;
        } else {
            for (int i = 2; i < 6; i++) {
                while (num % i == 0) {//对2，3，4，5，能对4整除就能对2整除
                    num /= i;
                }
            }
            return num == 1;
        }
    }
}
