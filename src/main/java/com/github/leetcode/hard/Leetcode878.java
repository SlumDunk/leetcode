package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/11/19 00:06
 * @Description: A positive integer is magical if it is divisible by either A or B.
 * <p>
 * Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 1, A = 2, B = 3
 * Output: 2
 * Example 2:
 * <p>
 * Input: N = 4, A = 2, B = 3
 * Output: 6
 * Example 3:
 * <p>
 * Input: N = 5, A = 2, B = 4
 * Output: 10
 * Example 4:
 * <p>
 * Input: N = 3, A = 6, B = 4
 * Output: 8
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * 2 <= A <= 40000
 * 2 <= B <= 40000
 */
public class Leetcode878 {
    public int nthMagicalNumber(int N, int A, int B) {
        if (B < A) {
            return nthMagicalNumber(N, B, A);
        }
        long start = 0, end = Long.MAX_VALUE;
        while (start+1 < end) {
            long mid = start + (end - start) / 2;
            if (check(A, B, mid) < N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if(check(A, B, start) == N) {
            return (int) (start % (1e9 + 7));
        }else{
            return (int) (end % (1e9 + 7));
        }
    }

    private long check(int A, int B, long mid) {
        long count = 0;
        int lcm = lcm(A, B);

        count += (mid / A);
        if (lcm != B) {
            count += (mid / B);
            //去除那些两个数都能除尽的
            count -= (mid / lcm);
        }
        return count;
    }

    /**
     * 求两个数的积/最大公约数
     *
     * @param p
     * @param q
     * @return
     */
    public int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }

    /**
     * 辗转相除法求最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
