package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 15:29
 * @Description: Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * <p>
 * For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
 * <p>
 * Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.
 * <p>
 * However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
 * <p>
 * Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
 * <p>
 * Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
 * <p>
 * Note:
 * <p>
 * The length of words1 and words2 will not exceed 1000.
 * The length of pairs will not exceed 2000.
 * The length of each pairs[i] will be 2.
 * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class Leetcode734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();

        for (List<String> pair :
                pairs) {
            map.putIfAbsent(pair.get(0), new HashSet<>());
            map.putIfAbsent(pair.get(1), new HashSet<>());
            map.get(pair.get(0)).add(pair.get(1));
            map.get(pair.get(1)).add(pair.get(0));
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i]) || !map.get(words1[i]).contains(words2[i])) {
                return false;
            }
        }
        return true;
    }
}
