package com.github.leetcode.easy;

/**
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits
 * in their binary representation.
 * <p>
 * (Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written
 * in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)
 * <p>
 * Example 1:
 * <p>
 * Input: L = 6, R = 10
 * Output: 4
 * Explanation:
 * 6 -> 110 (2 set bits, 2 is prime)
 * 7 -> 111 (3 set bits, 3 is prime)
 * 9 -> 1001 (2 set bits , 2 is prime)
 * 10->1010 (2 set bits , 2 is prime)
 * Example 2:
 * <p>
 * Input: L = 10, R = 15
 * Output: 5
 * Explanation:
 * 10 -> 1010 (2 set bits, 2 is prime)
 * 11 -> 1011 (3 set bits, 3 is prime)
 * 12 -> 1100 (2 set bits, 2 is prime)
 * 13 -> 1101 (3 set bits, 3 is prime)
 * 14 -> 1110 (3 set bits, 3 is prime)
 * 15 -> 1111 (4 set bits, 4 is not prime)
 * Note:
 * <p>
 * L, R will be integers L <= R in the range [1, 10^6].
 * R - L will be at most 10000.
 *
 * @author liuzhongda
 */
public class Leetcode762 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i = L; i <= R; i++) {
            int num = countSetBit(i);
            if (isPrime(num)) {
                result++;
            }

        }
        return result;
    }

    /**
     * 判断是否是质数
     *
     * @param num
     * @return
     */
    private boolean isPrime(int num) {
        // TODO Auto-generated method stub
        boolean isPrime = true;
        if (num == 1) {
            return false;
        }
        if (num == 2 || num == 3) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * 计算二进制形式拥有1的个数
     *
     * @param num
     * @return
     */
    private int countSetBit(int num) {
        // TODO Auto-generated method stub
        int result = 0;
        do {
            //求余为1证明末尾是1
            if (num % 2 != 0)
                result++;
            //右移1位
            num = num >> 1;
        } while (num > 0);
        return result;
    }

    /**
     * another method to count prime set bits of number
     *
     * @param L
     * @param R
     * @return
     */
    public int anotherCountPrimeSetBits(int L, int R) {
        boolean[] isPrime = new boolean[32];
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int prime : primes)
            isPrime[prime] = true;
        int ans = 0;
        for (int i = L; i <= R; ++i) {
            if (isPrime[Integer.bitCount(i)])
                ans += 1;
        }
        return ans;
    }

}
