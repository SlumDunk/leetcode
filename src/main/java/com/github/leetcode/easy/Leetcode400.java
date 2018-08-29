package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 8/28/18 18:49
 * @Description:
 */
public class Leetcode400 {
    public static void main(String[] args) {
        Leetcode400 leetcode400 = new Leetcode400();
        System.out.println(leetcode400.findNthDigit(192));
    }

    public int findNthDigit(int n) {
        long digit = 1, ith = 1, base = 9;
        while (n > base * digit) {
            n -= (base * digit);
            digit++;
            ith += base;
            base *= 10;
        }
        return (String.valueOf(ith + (n - 1) / digit)).charAt((n - 1) % (int) digit) - '0';
    }
}
