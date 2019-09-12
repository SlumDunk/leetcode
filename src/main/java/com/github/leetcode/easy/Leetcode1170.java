package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/11/19 11:46
 * @Description: Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * <p>
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 * <p>
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */
public class Leetcode1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] qFrequency = new int[queries.length];
        int[] wFrequency = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            qFrequency[i] = helper(queries[i]);
        }

        for (int i = 0; i < words.length; i++) {
            wFrequency[i] = helper(words[i]);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (wFrequency[j] > qFrequency[i]) {
                    result[i]++;
                }
            }
        }
        return result;
    }

    public int helper(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                return map[i];
            }
        }

        return -1;
    }
}
