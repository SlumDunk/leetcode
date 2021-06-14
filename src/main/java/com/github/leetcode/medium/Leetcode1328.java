package com.github.leetcode.medium;

/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
 * <p>
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 * <p>
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
 * Of all the ways, "aaccba" is the lexicographically smallest.
 * Example 2:
 * <p>
 * Input: palindrome = "a"
 * Output: ""
 * Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
 * Example 3:
 * <p>
 * Input: palindrome = "aa"
 * Output: "ab"
 * Example 4:
 * <p>
 * Input: palindrome = "aba"
 * Output: "abb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= palindrome.length <= 1000
 * palindrome consists of only lowercase English letters.
 */
public class Leetcode1328 {
    public String breakPalindrome(String palindrome) {
        // len is 1
        if (palindrome == null || palindrome.length() <= 1) {
            return "";
        } else {
            int len = palindrome.length();
            char[] array = palindrome.toCharArray();
            if (len % 2 == 0) {// even len
                for (int i = 0; i < len; i++) {
                    char c = array[i];
                    if (c != 'a') {
                        array[i] = 'a';
                        return new String(array);
                    } else {
                        if (i == len - 1) {
                            array[i] = 'b';
                            return new String(array);
                        }
                    }
                }
            } else {// odd len
                for (int i = 0; i < len; i++) {
                    if (i == len / 2) {
                        continue;
                    }
                    char c = array[i];
                    if (c != 'a') {
                        array[i] = 'a';
                        return new String(array);
                    } else {
                        if (i == len - 1) {
                            array[i] = 'b';
                            return new String(array);
                        }
                    }
                }
            }
            return "";
        }
    }
}
