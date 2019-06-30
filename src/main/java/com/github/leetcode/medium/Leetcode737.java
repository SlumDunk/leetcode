package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 21:32
 * @Description: Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
 * <p>
 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
 * <p>
 * Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
 * <p>
 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
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
public class Leetcode737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        /**
         * 维持节点和祖宗的关系
         */
        HashMap<String, String> components = new HashMap<>();
        if (words1.length != words2.length) return false;
        for (String word1 : words1)
            components.put(word1, word1);
        for (String word2 : words2)
            components.put(word2, word2);
        for (List<String> pair : pairs) {
            String s1 = pair.get(0);
            String s2 = pair.get(1);
            merge(components, s1, s2);
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            String p1 = findParent(components, word1);
            String p2 = findParent(components, word2);
            if (!p1.equals(p2)) return false;
        }
        return true;
    }

    /**
     * 找节点的祖宗
     * @param components
     * @param s
     * @return
     */
    String findParent(HashMap<String, String> components, String s) {
        if (!components.containsKey(s)) {
            components.put(s, s);
            return s;
        }
        while (!components.get(s).equals(s)) {
            s = components.get(s);
        }
        return s;
    }

    /**
     * 合并节点
     * @param components
     * @param s1
     * @param s2
     */
    void merge(HashMap<String, String> components, String s1, String s2) {
        String p1 = findParent(components, s1);
        String p2 = findParent(components, s2);
        components.put(p1, p2);
    }
}
