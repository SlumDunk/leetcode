package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/29/19 22:09
 * @Description: Given two integers A and B, return any string S such that:
 * <p>
 * S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
 * The substring 'aaa' does not occur in S;
 * The substring 'bbb' does not occur in S.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = 1, B = 2
 * Output: "abb"
 * Explanation: "abb", "bab" and "bba" are all correct answers.
 * Example 2:
 * <p>
 * Input: A = 4, B = 1
 * Output: "aabaa"
 */
public class Leetcode984 {
    public String strWithout3a3b(int A, int B) {
        String s1 = "ba", s2 = "bba";
        StringBuilder sb = new StringBuilder();
        if (A > B) {
            int n = A;
            A = B;
            B = n;
            s1 = "ab";
            s2 = "aab";
        }
        while (B > 0 && A > 0) {
            if (B > A) {
                sb.append(s2);
                B = B - 2;
                A--;
            } else {
                sb.append(s1);
                B--;
                A--;
            }
        }
        while (A > 0) {
            sb.append(s1.charAt(1));
            A--;
        }
        while (B > 0) {
            sb.append(s1.charAt(0));
            B--;
        }
        return sb.toString();
    }
}
