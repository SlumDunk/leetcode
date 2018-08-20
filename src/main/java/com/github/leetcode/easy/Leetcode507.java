package com.github.leetcode.easy;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * <p>
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class Leetcode507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return Boolean.FALSE;
        int sum = 1;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) sum += (i + num / i);
            if (i * i == num) sum -= i;
            if (sum > num) return Boolean.FALSE;
        }
        return sum == num;
    }
}
