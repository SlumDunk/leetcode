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
        //找到能整除的数，即factor
        if (num == 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;//具有对称性
                sum += (num / i);
            }
        }
        System.out.println(sum);
        return sum == num;
    }
}
