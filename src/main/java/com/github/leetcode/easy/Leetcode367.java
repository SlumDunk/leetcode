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
        //二分查找
        if (num <= 1) {
            return true;
        } else {
            long left = 0, right = num / 2;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (mid * mid == num)
                    return true;
                if (num > mid * mid) left++;
                else
                    right = mid - 1;
            }
            return false;
        }
    }
}
