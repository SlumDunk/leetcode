package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/7/19 23:46
 * @Description: A message containing letters from A-Z is being encoded to numbers using the following mapping way:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.
 * <p>
 * Given the encoded message containing digits and the character '*', return the total number of ways to decode it.
 * <p>
 * Also, since the answer may be very large, you should return the output mod 109 + 7.
 * <p>
 * Example 1:
 * Input: "*"
 * Output: 9
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
 * Example 2:
 * Input: "1*"
 * Output: 9 + 9 = 18
 * Note:
 * The length of the input string will fit in range [1, 105].
 * The input string will only contain the character '*' and digits '0' - '9'.
 */
public class Leetcode639 {
    public int numDecodings(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        long MOD = 1000000007;
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i - 1] * cnt1(charArray[i - 1]);
            if (i > 1) {
                f[i] += f[i - 2] * cnt2(charArray[i - 2], charArray[i - 1]);
            }
            f[i] %= MOD;
        }
        return (int) f[n];
    }

    /**
     * 一个字符的可能组合种类
     *
     * @param c
     * @return
     */
    private int cnt1(char c) {
        if (c == '0') {
            return 0;
        }
        if (c != '*') {
            return 1;
        }
        return 9;
    }

    /**
     * 两个字符的可能组合种类
     *
     * @param c2
     * @param c1
     * @return
     */
    private int cnt2(char c2, char c1) {
        //c2='0'
        if (c2 == '0') {
            return 0;
        }
        //c2='1'
        if (c2 == '1') {
            if (c1 == '*') {
                return 9;
            }
            return 1;
        }
        //c2='2'
        if (c2 == '2') {
            if (c1 == '*') {
                return 6;
            }
            if (c1 <= '6') {
                return 1;
            }
            return 0;
        }
        //c2 '3'-'9'
        if (c2 >= '3' && c2 <= '9') {
            return 0;
        }
        //c2='*'
        if (c1 >= '0' && c1 <= '6') {
            return 2;
        }
        if (c1 >= '7' && c1 <= '9') {
            return 1;
        }
        //c2='*' c1='*'
        return 15;
    }
}
