package com.github.leetcode.medium;

/**
 * You are given a positive integer primeFactors. You are asked to construct a positive integer n that satisfies the following conditions:
 * <p>
 * The number of prime factors of n (not necessarily distinct) is at most primeFactors.
 * The number of nice divisors of n is maximized. Note that a divisor of n is nice if it is divisible by every prime factor of n. For example, if n = 12, then its prime factors are [2,2,3], then 6 and 12 are nice divisors, while 3 and 4 are not.
 * Return the number of nice divisors of n. Since that number can be too large, return it modulo 109 + 7.
 * <p>
 * Note that a prime number is a natural number greater than 1 that is not a product of two smaller natural numbers. The prime factors of a number n is a list of prime numbers such that their product equals n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: primeFactors = 5
 * Output: 6
 * Explanation: 200 is a valid value of n.
 * It has 5 prime factors: [2,2,2,5,5], and it has 6 nice divisors: [10,20,40,50,100,200].
 * There is not other value of n that has at most 5 prime factors and more nice divisors.
 * Example 2:
 * <p>
 * Input: primeFactors = 8
 * Output: 18
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= primeFactors <= 109
 */
public class Leetcode1808 {

    int mod = 1000000000 + 7;

    /**
     * https://www.youtube.com/watch?v=JCaQo68gHXo
     *
     * @param primeFactors
     * @return
     */
    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 4) {
            return primeFactors;
        }
        int a, b;
        if (primeFactors % 3 == 0) {
            a = primeFactors / 3;
            b = 0;
        } else if (primeFactors % 3 == 2) {
            a = (primeFactors - 2) / 3;
            b = 1;
        } else {
            a = (primeFactors - 4) / 3;
            b = 2;
        }

        long ans = 1;
        ans = ans * quickMul(3, a) % mod;
        ans = ans * quickMul(2, b) % mod;
        return (int)ans;
    }

    private long quickMul(int x, int n) {
        if (n == 0) {
            return 1;
        }
        long y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y % mod : y * y * x % mod;
    }
}
