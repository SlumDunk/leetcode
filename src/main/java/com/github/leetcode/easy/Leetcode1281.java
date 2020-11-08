package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/1/20 20:21
 * @Description: Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 * <p>
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public class Leetcode1281 {
    public static void main(String[] args) {
        Leetcode1281 leetcode1281 = new Leetcode1281();
        leetcode1281.subtractProductAndSum(705);
    }

    public int subtractProductAndSum(int n) {
        int count = 0;
        int copyN = n;

        while (n > 0) {
            count++;
            n = n / 10;
        }

        int[] arr = new int[count];
        int idx = 0;
        int ans = 0;
        while (copyN > 0) {
            arr[idx++] = copyN % 10;
            copyN = copyN / 10;
        }

        int product = 1;
        for (int i = 0; i < count; i++) {
            ans -= arr[i];
            product *= arr[i];
        }
        ans += product;
        return ans;

    }
}
