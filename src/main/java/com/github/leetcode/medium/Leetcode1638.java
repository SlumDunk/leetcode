package com.github.leetcode.medium;

/**
 * Given two strings s and t, find the number of ways you can choose a non-empty substring of s and replace a single character by a different character such that the resulting substring is a substring of t. In other words, find the number of substrings in s that differ from some substring in t by exactly one character.
 * <p>
 * For example, the underlined substrings in "computer" and "computation" only differ by the 'e'/'a', so this is a valid way.
 * <p>
 * Return the number of substrings that satisfy the condition above.
 * <p>
 * A substring is a contiguous sequence of characters within a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aba", t = "baba"
 * Output: 6
 * Explanation: The following are the pairs of substrings from s and t that differ by exactly 1 character:
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * ("aba", "baba")
 * The underlined portions are the substrings that are chosen from s and t.
 * ​​Example 2:
 * Input: s = "ab", t = "bb"
 * Output: 3
 * Explanation: The following are the pairs of substrings from s and t that differ by 1 character:
 * ("ab", "bb")
 * ("ab", "bb")
 * ("ab", "bb")
 * ​​​​The underlined portions are the substrings that are chosen from s and t.
 * Example 3:
 * Input: s = "a", t = "a"
 * Output: 0
 * Example 4:
 * <p>
 * Input: s = "abe", t = "bbc"
 * Output: 10
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 100
 * s and t consist of lowercase English letters only.
 */
public class Leetcode1638 {
    /**
     * https://www.youtube.com/watch?v=PlnhYLLnL9c
     *
     * @param s
     * @param t
     * @return
     */
    public int countSubstrings(String s, String t) {
        int m = s.length();
        int n = t.length();
        s = "#" + s + "#";
        t = "#" + t + "#";
        int[][] dp1 = new int[s.length()][t.length()];
        int[][] dp2 = new int[s.length()][t.length()];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp1[i][j] = dp1[i - 1][j - 1] + 1;
                } else {
                    dp1[i][j] = 0;
                }
            }
        }

        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp2[i][j] = dp2[i + 1][j + 1] + 1;
                } else {
                    dp2[i][j] = 0;
                }
            }
        }

        int ret = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    ret += (dp1[i - 1][j - 1] + 1) * (dp2[i + 1][j + 1] + 1);
                }
            }
        }

        return ret;
    }
}
