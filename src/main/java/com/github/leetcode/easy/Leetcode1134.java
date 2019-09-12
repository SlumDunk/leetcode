package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/9/19 12:24
 * @Description: The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.
 * <p>
 * Given a positive integer N, return true if and only if it is an Armstrong number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 153
 * Output: true
 * Explanation:
 * 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
 * Example 2:
 * <p>
 * Input: 123
 * Output: false
 * Explanation:
 * 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^8
 */
public class Leetcode1134 {
    public static void main(String[] args) {
        Leetcode1134 leetcode1134 = new Leetcode1134();
        leetcode1134.isArmstrong(370);
    }

    public boolean isArmstrong(int N) {
        int k = 1;
        int copyN = N;
        while (N / 10 != 0) {
            k++;
            N = N / 10;
        }
        N = copyN;
        while (copyN != 0) {
            int num = copyN % 10;
            N = N - (int) Math.pow(num, k);
            copyN = copyN / 10;
        }
        if (N == 0) {
            return true;
        } else {
            return false;
        }
    }
}
