package com.github.leetcode.hard;

import java.math.BigInteger;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 12:08
 * @Description: For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
 * <p>
 * Now given a string representing n, you should return the smallest good base of n in string format.
 * <p>
 * Example 1:
 * <p>
 * Input: "13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "4681"
 * Output: "8"
 * Explanation: 4681 base 8 is 11111.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: "1000000000000000000"
 * Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 * <p>
 * <p>
 * Note:
 * <p>
 * The range of n is [3, 10^18].
 * The string representing n is always valid and will not have leading zeros.
 */
public class Leetcode483 {
    /**
     * 等比数列求和 推导出关系
     * 二分查找
     * <p>
     * https://leetcode.com/problems/smallest-good-base/discuss/96589/Java-solution-with-hand-writing-explain
     *
     * @param n
     * @return
     */
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long res = 0;
        for (int k = 60; k >= 2; k--) {
            long s = 2, e = num;
            while (s < e) {
                long m = s + (e - s) / 2;
                BigInteger left = BigInteger.valueOf(m);
                left = left.pow(k).subtract(BigInteger.ONE);
                BigInteger right = BigInteger.valueOf(num).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
                int cmr = left.compareTo(right);
                if (cmr == 0) {
                    res = m;
                    break;
                } else if (cmr < 0) {
                    s = m + 1;
                } else {
                    e = m;
                }
            }

            if (res != 0) break;
        }

        return "" + res;
    }
}
