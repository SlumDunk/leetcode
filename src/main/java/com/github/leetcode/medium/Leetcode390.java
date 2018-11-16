package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 21:25
 * @Description: There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 */
public class Leetcode390 {
    public int lastRemaining(int n) {
        return leftToRight(n);
    }

    private static int leftToRight(int n) {
        if (n <= 2) return n;
        return 2 * rightToLeft(n / 2);
    }

    private static int rightToLeft(int n) {
        if (n <= 2) return 1;
        if (n % 2 == 1) return 2 * leftToRight(n / 2);
        return 2 * leftToRight(n / 2) - 1;
    }
}
