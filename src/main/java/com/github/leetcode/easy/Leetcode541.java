package com.github.leetcode.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class Leetcode541 {
    public static void main(String[] args) {
        Leetcode541 leetcode541 = new Leetcode541();
        leetcode541.reverseStr("abcdefg", 2);
    }

    public String reverseStr(String s, int k) {
        StringBuffer result = new StringBuffer();
        reverse(s, k, result);

        return result.toString();
    }

    private void reverse(String s, int k, StringBuffer result) {
        if (s.length() < k) {
            for (int i = s.length() - 1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            return;
        } else {
            if (s.length() >= k && s.length() <= 2 * k) {
                for (int i = k - 1; i >= 0; i--) {
                    result.append(s.charAt(i));
                }
                for (int i = k; i < s.length(); i++) {
                    result.append(s.charAt(i));
                }
            } else {
                reverse(s.substring(0, 2 * k), k, result);
                reverse(s.substring(2 * k), k, result);
            }
        }
    }
}
