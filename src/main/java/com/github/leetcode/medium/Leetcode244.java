package com.github.leetcode.medium;

import com.github.leetcode.vo.Interval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 11:50
 * @Description: Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Leetcode244 {
    class WordDistance {
        private Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(words[i], list);
                } else {
                    map.get(words[i]).add(i);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int res = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;
            while (i < l1.size() && j < l2.size()) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(i)));
                if (l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}
