package com.github.leetcode.easy;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class Leetcode686 {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder buffer = new StringBuilder(A);
        //buffer拼接字符串A，直到找到子串为B或者直到buffer的长度大于两个字符串长度之和
        while (buffer.length() <= A.length() + B.length()) {
            if (buffer.lastIndexOf(B) != -1) {
                return buffer.length() / A.length();
            }
            buffer.append(A);
        }
        //返回重复次数
        return buffer.lastIndexOf(B) > -1 ? buffer.length() / A.length() : -1;
    }
}
