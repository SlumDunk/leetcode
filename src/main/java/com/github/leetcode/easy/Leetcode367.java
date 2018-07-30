package com.github.leetcode.easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Returns: True
 * Example 2:
 * <p>
 * Input: 14
 * Returns: False
 */
public class Leetcode367 {
    public boolean isPerfectSquare(int num) {
        if (num < 1) return Boolean.FALSE;
        if (num == 1) {
            return Boolean.TRUE;
        } else {
            long left = 0, right = num / 2;
            while (left <= right) {
                long mid = (left + right) / 2;
                long val = mid * mid;
                if (val == num) return Boolean.TRUE;
                else if (val > num) right = mid - 1;
                else left = mid + 1;
            }
        }
        return Boolean.FALSE;
    }
}
