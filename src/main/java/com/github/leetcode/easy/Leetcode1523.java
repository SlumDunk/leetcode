package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 20:00
 * @Description: Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: low = 3, high = 7
 * Output: 3
 * Explanation: The odd numbers between 3 and 7 are [3,5,7].
 * Example 2:
 * <p>
 * Input: low = 8, high = 10
 * Output: 1
 * Explanation: The odd numbers between 8 and 10 are [9].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= low <= high <= 10^9
 */
public class Leetcode1523 {
    public int countOdds(int low, int high) {
        int atleast = (high - low) / 2;
        if (low % 2 != 0 || high % 2 != 0) {
            return ++atleast;
        }
        return atleast;
    }
}
