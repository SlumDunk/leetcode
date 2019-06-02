package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 09:24
 * @Description: Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * <p>
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * <p>
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * <p>
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 */
public class Leetcode472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Trie root = new Trie();
        for (String word :
                words) {
            if (!word.isEmpty()) root.add(word, 0);
        }

        for (String word :
                words) {
            if (root.match(word, 0)) res.add(word);
        }
        return res;
    }


    class Trie {
        boolean end;
        int level;
        Trie[] next;
        /**
         * 根节点
         */
        Trie root;

        Trie() {
            this(null, 0);
        }

        Trie(Trie root, int level) {
            end = false;
            next = new Trie[26];
            this.root = root;
            this.level = level;
        }

        void add(String s, int idx) {
            if (idx == s.length()) end = true;
            else {
                int i = s.charAt(idx) - 'a';
                if (next[i] == null) next[i] = new Trie(root == null ? this : root, level + 1);
                next[i].add(s, idx + 1);
            }
        }

        boolean match(String s, int idx) {
            //排除本身就等于这字符串的单词
            if (idx == s.length()) return end && idx != level;
            int i = s.charAt(idx) - 'a';
            if (next[i] != null && next[i].match(s, idx + 1)) return true;
            if (end && root.match(s, idx)) return true;
            return false;
        }

    }
}
