package com.github.leetcode.easy;

/**
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 * <p>
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * Example 2:
 * <p>
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * Example 3:
 * <p>
 * Input: s1 = "kelb", s2 = "kelb"
 * Output: true
 * Explanation: The two strings are already equal, so no string swap operation is required.
 * Example 4:
 * <p>
 * Input: s1 = "abcd", s2 = "dcba"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 */
public class Leetcode1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        } else {
            if (s1.equals(s2)) {
                return true;
            } else {
                int firstDiffIndex = -1;
                int secondDiffIndex = -1;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        if (firstDiffIndex == -1) {
                            firstDiffIndex = i;
                        } else if (secondDiffIndex == -1) {
                            secondDiffIndex = i;
                        } else {
                            return false;
                        }
                    }
                }

                if (secondDiffIndex == -1) {
                    return false;
                }

                return s1.charAt(firstDiffIndex) == s2.charAt(secondDiffIndex) && s1.charAt(secondDiffIndex) == s2.charAt(firstDiffIndex);
            }
        }
    }
}
