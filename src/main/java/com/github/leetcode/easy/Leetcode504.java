package com.github.leetcode.easy;

/**
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class Leetcode504 {
    public String convertToBase7(int num) {
        StringBuffer result = new StringBuffer();
        int mod;
        Boolean isNegative = Boolean.FALSE;
        if (num < 0) {
            num = Math.abs(num);
            isNegative = Boolean.TRUE;
        }
        while (num > 0) {
            mod = num % 7;
            result.append(mod);
            num = num / 7;
        }

        return isNegative == Boolean.TRUE ? "-" + result.reverse().toString() : result.reverse().toString();
    }
}
