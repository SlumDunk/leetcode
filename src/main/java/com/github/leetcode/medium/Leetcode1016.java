package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 08:31
 * @Description: Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "0110", N = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: S = "0110", N = 4
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 1000
 * 1 <= N <= 10^9
 */
public class Leetcode1016 {
    public boolean queryString(String S, int N) {
        for (int i = N; i >= 1; i--) {
            if (S.indexOf(Integer.toBinaryString(i)) == -1)
                return false;
        }
        return true;
    }
}
