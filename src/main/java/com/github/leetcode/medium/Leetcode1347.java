package com.github.leetcode.medium;

/**
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 * <p>
 * Return the minimum number of steps to make t an anagram of s.
 * <p>
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 * <p>
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 * <p>
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 * <p>
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 * <p>
 * Input: s = "friend", t = "family"
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 */
public class Leetcode1347 {
    /**
     * @param s
     * @param t
     * @return
     */
    public int minSteps(String s, String t) {
        int[] recordS = new int[26];
        int[] recordT = new int[26];

        for (int i = 0; i < s.length(); i++) {
            recordS[s.charAt(i) - 'a']++;
            recordT[t.charAt(i) - 'a']++;
        }

        int diffCount = 0;

        for (int i = 0; i < 26; i++) {
            diffCount += Math.abs(recordS[i] - recordT[i]);
        }
        return diffCount / 2;
    }
}
