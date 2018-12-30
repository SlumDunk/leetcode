package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/29/18 17:56
 * @Description: Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 5
 * Output: false
 */
public class Leetcode342 {
    public boolean isPowerOfFour(int num) {
        //根据每次1出现的位置
        //1,4,16,64
        //000000001,00000100,00010000,01000000
        //01010101 0x55
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
