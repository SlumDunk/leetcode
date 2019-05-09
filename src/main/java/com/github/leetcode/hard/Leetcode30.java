package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 09:54
 * @Description: You are given a string, word, and a list of words, words, that are all of the same length. Find all starting indices of substring(word) in word that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * word = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * <p>
 * Input:
 * word = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 */
public class Leetcode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0) {
            return resultList;
        }
        Map<String, Integer> toFind = new HashMap<>();
        Map<String, Integer> found = new HashMap<>();
        int m = words.length, n = words[0].length();
        for (int i = 0; i < m; i++) {
            if (!toFind.containsKey(words[i])) {
                toFind.put(words[i], 1);
            } else {
                toFind.put(words[i], toFind.get(words[i]) + 1);
            }
        }

        for (int i = 0; i <= s.length() - m * n; i++) {
            found.clear();
            int j = 0;
            for (; j < m; j++) {
                int k = i + j * n;
                String sub = s.substring(k, k + n);
                if (!toFind.containsKey(sub)) {
                    break;
                }
                if (!found.containsKey(sub)) {
                    found.put(sub, 1);
                } else {
                    found.put(sub, found.get(sub) + 1);
                }

                if (found.get(sub) > toFind.get(sub)) {
                    break;
                }
            }
            if (j == m) {
                resultList.add(i);
            }
        }

        return resultList;
    }
}
