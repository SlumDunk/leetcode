package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 16:42
 * @Description: Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 * <p>
 * Return how many groups have the largest size.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 * Example 3:
 * <p>
 * Input: n = 15
 * Output: 6
 * Example 4:
 * <p>
 * Input: n = 24
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^4
 */
public class Leetcode1399 {
    public int countLargestGroup(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        int[] counts = new int[37]; // max sum of digits of n <= 10000 is 36 (sum of digits of 9999)
        for (int i = 1; i <= n; i++) {
            dp[i] = i % 10 + dp[i / 10];
            counts[dp[i]]++;
        }
        int max = 0;
        for (int count : counts)
            max = Math.max(max, count);
        for (int count : counts) {
            if (count == max)
                ans++;
        }
        return ans;
    }
}
