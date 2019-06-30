package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 22:09
 * @Description: Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).
 * <p>
 * The returned string must have no leading zeroes, unless the string is "0".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: "110"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 = 2
 * Example 2:
 * <p>
 * Input: 3
 * Output: "111"
 * Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * Example 3:
 * <p>
 * Input: 4
 * Output: "100"
 * Explantion: (-2) ^ 2 = 4
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= N <= 10^9
 */
public class Leetcode1017 {
    public String baseNeg2(int N) {
        StringBuilder res = new StringBuilder();
        while (N != 0) {
            res.append(N & 1);
            N = -(N >> 1);
        }
        return res.length() > 0 ? res.reverse().toString() : "0";
    }
}
