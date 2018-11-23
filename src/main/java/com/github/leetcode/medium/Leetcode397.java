package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/22/18 10:02
 * @Description: Given a positive integer n and you can do operations as follow:
 * <p>
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 8
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * Example 2:
 * <p>
 * Input:
 * 7
 * <p>
 * Output:
 * 4
 * <p>
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */
public class Leetcode397 {
    public static void main(String[] args) {
        Leetcode397 leetcode397 = new Leetcode397();
        leetcode397.integerReplacement(2147483647);
    }

    public int count = 0;

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        count = helper(n, 0);
        return count;
    }

    private int helper(long n, int number) {
        if (n == 1) {
            return number;
        } else if (n % 2 == 0) {
            number++;
            return helper(n / 2, number);
        } else {
            number++;
            return Math.min(helper(n + 1, number), helper(n - 1, number));
        }
    }
}
