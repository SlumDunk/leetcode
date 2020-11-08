package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 19:09
 * @Description: Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 987
 * Output: "987"
 * Example 2:
 * <p>
 * Input: n = 1234
 * Output: "1.234"
 * Example 3:
 * <p>
 * Input: n = 123456789
 * Output: "123.456.789"
 * Example 4:
 * <p>
 * Input: n = 0
 * Output: "0"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n < 2^31
 */
public class Leetcode1556 {
    public String thousandSeparator(int n) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();

        int count = 0;
        while (n > 0) {
            if (count == 3) {
                count = 1;
                sb.append("." + n % 10);
            } else {
                count++;
                sb.append(n % 10);
            }
            n /= 10;
        }

        return sb.reverse().toString();
    }
}
