package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 8/31/18 10:58
 * @Description: Find the largest palindrome made from the product of two n-digit numbers.
 * <p>
 * Since the result could be very large, you should return the largest palindrome mod 1337.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * <p>
 * Output: 987
 * <p>
 * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 * <p>
 * Note:
 * <p>
 * The range of n is [1,8].
 */
public class Leetcode479 {
    public static void main(String[] args) {
        Leetcode479 leetcode479 = new Leetcode479();
        leetcode479.largestPalindrome(1);
    }

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int high = (int) Math.pow(10, n) - 1, low = high / 10;
        for (int i = high; i > low; i--) {
            long palindrome = createPalindrome(i);
            for (long j = high; j > low; j--) {
                if (palindrome / j > high) {
                    break;
                }
                if (palindrome % j == 0) {
                    return (int) (palindrome % 1337);
                }
            }
        }
        return -1;
    }

    private long createPalindrome(int num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }
}
