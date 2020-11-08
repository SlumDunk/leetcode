package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 13:30
 * @Description: Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
 * <p>
 * For a given query word, the spell checker handles two categories of spelling mistakes:
 * <p>
 * Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
 * Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
 * Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
 * Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
 * In addition, the spell checker operates under the following precedence rules:
 * <p>
 * When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
 * When the query matches a word up to capitlization, you should return the first such match in the wordlist.
 * When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
 * If the query has no matches in the wordlist, you should return the empty string.
 * Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 * All strings in wordlist and queries consist only of english letters.
 */
public class Leetcode966 {
    class Trie {
        Trie[] children;
        char val;
        /**
         * 当前是否是单词
         */
        boolean isWord;
        /**
         * 在wordList中的位置
         */
        int index;

        public Trie(char val) {
            this.val = val;
            this.children = new Trie[52];
        }
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Trie root = new Trie(' ');
        buildTree(wordlist, root);
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int match = matchSearch(queries[i], root);
            if (match >= 0) {
                res[i] = wordlist[match];
                continue;
            }
            char[] chars = queries[i].toCharArray();
            match = likeSearch(chars, root, 0);
            if (match != Integer.MAX_VALUE) {
                res[i] = wordlist[match];
                continue;
            }
            match = vowelSearch(chars, root, 0);
            if (match != Integer.MAX_VALUE) {
                res[i] = wordlist[match];
                continue;
            }
            res[i] = "";
        }
        return res;
    }

    /**
     * 元音替换搜索
     *
     * @param word
     * @param root
     * @param index
     * @return
     */
    private int vowelSearch(char[] word, Trie root, int index) {
        if (index == word.length) return root.isWord ? root.index : Integer.MAX_VALUE;//如果这个词是单词 就返回下标 否则没有匹配上
        int res = Integer.MAX_VALUE;
        if (word[index] == 'a' || word[index] == 'e' || word[index] == 'i' || word[index] == 'o' || word[index] == 'u' ||
                word[index] == 'A' || word[index] == 'E' || word[index] == 'I' || word[index] == 'O' || word[index] == 'U') {
            char[] may = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
            for (char c : may) {
                int idx = c >= 'a' ? 26 + c - 'a' : c - 'A';
                Trie next = root.children[idx];
                if (next != null) res = Math.min(res, vowelSearch(word, next, index + 1));
            }
        } else {//否则不是元音字母 仅触发大小写敏感匹配
            int may = word[index] >= 'a' ? word[index] - 'a' : word[index] - 'A' + 26;
            int now = word[index] >= 'a' ? word[index] - 'a' + 26 : word[index] - 'A';
            Trie next = root.children[now];
            if (next != null) {
                res = vowelSearch(word, next, index + 1);
            }
            next = root.children[may];
            if (next != null) {//有这个节点
                res = Math.min(res, vowelSearch(word, next, index + 1));
            }
        }
        return res;
    }

    /**
     * 模糊匹配
     *
     * @param word
     * @param root
     * @param index
     * @return
     */
    private int likeSearch(char[] word, Trie root, int index) {
        if (index == word.length) return root.isWord ? root.index : Integer.MAX_VALUE;
        int may = word[index] >= 'a' ? word[index] - 'a' : word[index] - 'A' + 26;
        int now = word[index] >= 'a' ? word[index] - 'a' + 26 : word[index] - 'A';
        int res = Integer.MAX_VALUE;
        Trie next = root.children[now];
        if (next != null) {
            res = likeSearch(word, next, index + 1);
        }
        next = root.children[may];
        if (next != null) {
            res = Math.min(res, likeSearch(word, next, index + 1));
        }
        return res;
    }

    /**
     * 完全匹配
     *
     * @param word
     * @param root
     * @return
     */
    private int matchSearch(String word, Trie root) {
        Trie current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int id = c >= 'a' ? 26 + c - 'a' : c - 'A';
            Trie next = current.children[id];
            if (next == null) return -1;
            current = next;
        }
        return current.isWord ? current.index : -1;
    }

    /**
     * O(m*l1) m is the number of words, l1 is the average length of word
     *
     * @param wordlist
     * @param root
     */
    private void buildTree(String[] wordlist, Trie root) {
        Trie now = root;
        for (int i = 0; i < wordlist.length; i++) {
            char[] chars = wordlist[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                int id = 0;
                if (chars[j] >= 'a') id = 26 + chars[j] - 'a';
                else id = chars[j] - 'A';
                Trie next = now.children[id];
                if (next == null) {
                    now.children[id] = new Trie(chars[j]);
                    next = now.children[id];
                }
                now = next;
            }
            if (!now.isWord) {
                now.isWord = true;
                now.index = i;
            }
            now = root;
        }
    }

    /**
     * 用hashMap实现
     * <p>
     * O(m*l1+n*l2)
     *
     * @param wordlist
     * @param queries
     * @return
     */
    public String[] spellcheckerMap(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String, String> cap = new HashMap<>();
        HashMap<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            String lower = w.toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase(), devowel = lower.replaceAll("[aeiou]", "#");
            if (cap.containsKey(lower)) {
                queries[i] = cap.get(lower);
            } else if (vowel.containsKey(devowel)) {
                queries[i] = vowel.get(devowel);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }
}
