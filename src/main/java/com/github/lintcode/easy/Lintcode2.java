package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 21:52
 * @Description: Write an algorithm which computes the number of trailing zeros in n factorial.
 * <p>
 * Example
 * Example 1:
 * Input:  11
 * Output: 2
 * <p>
 * Explanation:
 * 11! = 39916800, so the output should be 2
 * <p>
 * Example 2:
 * Input:  5
 * Output: 1
 * <p>
 * Explanation:
 * 5! = 120, so the output should be 1.
 * <p>
 * Challenge
 * O(log N) time
 */
public class Lintcode2 {
    /*
    * @param n: An integer
    * @return: An integer, denote the number of trailing zeros in n!
    */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        //可以将每个数拆分成其素因子的乘积，可以发现，0是由2*5产生的，而5的数量一定小于2的数量，因此5的个数决定了结尾0的个数。
        //只要计算n的阶乘中，5这个素因子出现多少次即可。
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }
}
