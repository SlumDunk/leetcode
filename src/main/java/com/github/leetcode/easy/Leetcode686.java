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
        int m = A.length(), n = B.length();
        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n && A.charAt((i + j) % m) == B.charAt(j)) j++;
            if (j == n) {
                return (i + j - 1) / m + 1;
            }
        }
        return -1;
    }
}
