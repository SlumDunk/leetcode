package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/9/21 21:04
 * @Description: You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.
 * <p>
 * You are also given an integer maxCost.
 * <p>
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.
 * <p>
 * If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", t = "bcdf", maxCost = 3
 * Output: 3
 * Explanation: "abc" of s can change to "bcd". That costs 3, so the maximum length is 3.
 * Example 2:
 * <p>
 * Input: s = "abcd", t = "cdef", maxCost = 3
 * Output: 1
 * Explanation: Each character in s costs 2 to change to charactor in t, so the maximum length is 1.
 * Example 3:
 * <p>
 * Input: s = "abcd", t = "acde", maxCost = 0
 * Output: 1
 * Explanation: You can't make any change, so the maximum length is 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s and t only contain lower case English letters.
 */
public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int maxLen = 0, start = 0, currentCost = 0;
        for (int end = 0; end < s.length(); end++) {
            currentCost += Math.abs(s.charAt(end) - t.charAt(end));
            if (currentCost <= maxCost) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
        }
        return maxLen;
    }
}
