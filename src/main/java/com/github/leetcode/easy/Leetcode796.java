package com.github.leetcode.easy;

/**
 * We are given two strings, A and B.
 * <p>
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 * <p>
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * <p>
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 * <p>
 * A and B will have length at most 100.
 */
public class Leetcode796 {
    public static void main(String[] args) {
        Leetcode796 leetcode796 = new Leetcode796();
        System.out.println(leetcode796.rotateString("bqqutquvbtgouklsayfvzewpnrbwfcdmwctusunasdbpbmhnvy", "wpnrbwfcdmwctusunasdbpbmhnvybqqutquvbtgouklsayfvze"));
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.trim().length() == 0 && B.trim().length() == 0) {
            return true;
        }
        int len = A.length();
        for (int i = 0; i < len; i++) {
            if ((A.substring(i, len) + A.substring(0, i)).equals(B)) {
                return true;
            }
        }
        return false;

    }
}
