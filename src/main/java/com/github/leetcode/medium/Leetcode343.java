package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 13:31
 * @Description: Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * <p>
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class Leetcode343 {
    public static void main(String[] args) {
        Leetcode343 leetcode343 = new Leetcode343();
        System.out.println(leetcode343.integerBreak(10));
    }

    public int integerBreak(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] maxProduct = new int[n + 1];
        maxProduct[0] = 1;
        maxProduct[1] = 1;
        for (int i = 2; i <= n; i++) {
            int product = 1;
            for (int j = 1; j <= i - 1; j++) {
                product = Math.max(product, Math.max(j, maxProduct[j]) * Math.max(i - j, maxProduct[i - j]));
            }
            maxProduct[i] = product;
        }

        return maxProduct[n];
    }
}
