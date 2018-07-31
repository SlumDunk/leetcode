package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s != null && s.length() > 0) {
            int[] map = new int[256];
            for (int i = 0; i < p.length(); i++) {
                ++map[p.charAt(i)];
            }
            int left = 0, right = 0, cnt = p.length();
            while (right < s.length()) {
                if (map[s.charAt(right++)]-- >= 1) --cnt;
                if (cnt == 0) res.add(left);
                if (right - left == p.length() && map[s.charAt(left++)]++ >= 0) ++cnt;
            }
        }
        return res;
    }
}
