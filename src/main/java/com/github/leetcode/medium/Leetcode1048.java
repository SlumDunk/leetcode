package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 09:41
 * @Description: Given a list of words, each word consists of English lowercase letters.
 * <p>
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".
 * <p>
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 * <p>
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: one of the longest word chain is "a","ba","bda","bdca".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 */
public class Leetcode1048 {
    public int longestStrChain(String[] words) {
        //key为单词， value为组成路径的长度，当前单词往后
        Map<String, Integer> map = new HashMap<>();
        //key为长度，value为对应的单词
        Map<Integer, Set<String>> ws = new HashMap<>();
        int maxLen = 0;
        for(String w : words) {
            maxLen = Math.max(maxLen, w.length());
            map.put(w, 1);
            if(!ws.containsKey(w.length())) ws.put(w.length(), new HashSet<>());
            ws.get(w.length()).add(w);
        }
        int res = 1;
        //从最长的单词开始
        for(int i = maxLen; i >= 1; i--) {
            int next = i - 1;
            if(!ws.containsKey(next)) continue;
            Set<String> nextSet = ws.get(next);
            for(String w : ws.getOrDefault(i, new HashSet<>())) {
                for(int j = 0; j < w.length(); j++) {
                    StringBuilder sb = new StringBuilder(w);
                    //上一个候选单词
                    String nextWord = sb.deleteCharAt(j).toString();
                    if(nextSet.contains(nextWord)) {
                        int currVal = Math.max(map.get(nextWord), map.get(w) + 1);
                        res = Math.max(currVal, res);
                        map.put(nextWord, currVal);
                    }
                }
            }

        }
        return res;
    }
}
