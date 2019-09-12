package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 12:01
 * @Description: Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
 * <p>
 * (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5
 * Output: 12
 * Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
 * Example 2:
 * <p>
 * Input: n = 100
 * Output: 682289015
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 100
 */
public class Leetcode1175 {
    public int numPrimeArrangements(int n)
    {
        int c_prime = prime_count(n);

        long r = 1;
        for (int i = 2; i <= c_prime; ++i)
        {
            r = r * i;
            r %= 1000000007;
        }
        for (int i = 2; i <= n - c_prime; ++i)
        {
            r = r * i;
            r %= 1000000007;
        }

        return (int) r;
    }

    // find how many prime numbers in [1, n]
    int prime_count(int n)
    {
        if (n < 2) return 0;
        int count = 1;
        for (int i = 3; i <= n; ++i)
        {
            boolean is_prime = true;
            for (int j = 2; j * j <= i; ++j)
            {
                if (i % j == 0)
                {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) ++count;
        }

        return count;
    }
}
