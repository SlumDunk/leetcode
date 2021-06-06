package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/25/20 20:37
 * @Description: A decimal number can be converted to its Hexspeak representation by first converting it to an uppercase hexadecimal string, then replacing all occurrences of the digit 0 with the letter O, and the digit 1 with the letter I.  Such a representation is valid if and only if it consists only of the letters in the set {"A", "B", "C", "D", "E", "F", "I", "O"}.
 * <p>
 * Given a string num representing a decimal integer N, return the Hexspeak representation of N if it is valid, otherwise return "ERROR".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = "257"
 * Output: "IOI"
 * Explanation:  257 is 101 in hexadecimal.
 * Example 2:
 * <p>
 * Input: num = "3"
 * Output: "ERROR"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= N <= 10^12
 * There are no leading zeros in the given string.
 * All answers must be in uppercase letters.
 */
public class Leetcode1271 {
    public String toHexspeak(String num) {
        char hex[] = {'O', 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'A', 'B', 'C', 'D', 'E', 'F'};
        long n = Long.parseLong(num);
        String ans = "";
        while (n > 0) {
            int res = (int) (n % 16);
            if (hex[res] == ' ') return "ERROR";
            ans = hex[res] + ans;
            n /= 16;
        }
        return ans;
    }
}
