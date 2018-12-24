package com.github.leetcode.easy;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
public class Leetcode441 {
    public int arrangeCoins(int n) {
        //二分查找 等差数列求和公式
        if (n <= 1) {
            return n;
        }
        long left = 0, right = n;
        //注意条件
        while (left < right) {
            long mid = (left + right) / 2;
            //条件是小于等于 保证left最后比要得的值大1
            if (mid * (mid + 1) / 2 <= n) left = mid + 1;
            else right = mid;
        }

        return (int) left - 1;
    }
}
