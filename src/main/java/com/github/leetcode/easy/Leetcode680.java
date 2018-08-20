package com.github.leetcode.easy;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class Leetcode680 {

    public static void main(String[] args) {
        Leetcode680 leetcode680 = new Leetcode680();
        System.out.println(leetcode680.validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, 1);
    }

    private boolean valid(String s, int i, int j, int d) {
        if (i >= j) return Boolean.TRUE;
        if (s.charAt(i) == s.charAt(j)) {
            return valid(s, i + 1, j - 1, d);
        } else {
            return d > 0 && (valid(s, i + 1, j, d - 1) || valid(s, i, j - 1, d - 1));
        }
    }
}
