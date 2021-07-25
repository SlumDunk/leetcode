package com.github.leetcode.medium;

/**
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 * <p>
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class Leetcode1358 {
    public int numberOfSubstrings(String s) {
        int array[] = new int[3];
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            while (!(array[0] > 0 && array[1] > 0 && array[2] > 0) && j < s.length()) {
                array[s.charAt(j) - 'a']++;
                j++;
            }
            while (array[0] > 0 && array[1] > 0 && array[2] > 0 && i < s.length()) {
                count += s.length() - j + 1;
                array[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return count;
    }
}
