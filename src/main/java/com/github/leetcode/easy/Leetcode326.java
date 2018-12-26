package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/23/18 11:36
 * @Description: Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 */
public class Leetcode326 {
    public boolean isPowerOfThree(int n) {
        //以3为底，求对数结果
        if (n < 1) {
            return false;
        } else {
            double power = Math.log10(n) / Math.log10(3);
            //查看对数结果是否为整数
            return power == Math.ceil(power);
        }
    }
}
