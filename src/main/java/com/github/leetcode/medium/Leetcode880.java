package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 08:05
 * @Description: An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "leet2code3", K = 10
 * Output: "o"
 * Explanation:
 * The decoded string is "leetleetcodeleetleetcodeleetleetcode".
 * The 10th letter in the string is "o".
 * Example 2:
 * <p>
 * Input: S = "ha22", K = 5
 * Output: "h"
 * Explanation:
 * The decoded string is "hahahaha".  The 5th letter is "h".
 * Example 3:
 * <p>
 * Input: S = "a2345678999999999999999", K = 1
 * Output: "a"
 * Explanation:
 * The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= S.length <= 100
 * S will only contain lowercase letters and digits 2 through 9.
 * S starts with a letter.
 * 1 <= K <= 10^9
 * The decoded string is guaranteed to have less than 2^63 letters.
 */
public class Leetcode880 {
    public String decodeAtIndex(String S, int K) {
        //数字前面字符串的长度
        long len = 0;
        //最后一个出现的字符
        char lastc = 0;
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                if (++len == K) return "" + c;
                lastc = c;
            } else {//出现的是数字
                long m = len * (c - '0');
                if (K == m) return "" + lastc;
                else if (m > K) {
                    if (K % len == 0) return "" + lastc;
                    return decodeAtIndex(S, (int) (K % len));
                }
                len = m;
            }
        }

        return "";
    }
}
