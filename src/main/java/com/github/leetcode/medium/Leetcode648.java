package com.github.leetcode.medium;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 14:48
 * @Description: In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * <p>
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 * <p>
 * You need to output the sentence after the replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * <p>
 * <p>
 * Note:
 * <p>
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class Leetcode648 {
    /**
     * O(k*m+n*k)
     *
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty() || sentence == null || sentence.length() == 0) return sentence;

        Trie trie = new Trie();
        for (String key : dict) {
            trie.insert(key);
        }

        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");
        for (String word : words) {
            sb.append(trie.findRoot(word)).append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    class Trie {
        class TrieNode {
            TrieNode[] kids;
            String word;
            boolean isEndOfWord;

            public TrieNode() {
                kids = new TrieNode[26];
                word = "";
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入一个单词
         *
         * @param key
         */
        public void insert(String key) {
            TrieNode parent = root;
            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'a';

                if (parent.kids[idx] == null) {
                    parent.kids[idx] = new TrieNode();
                }
                parent = parent.kids[idx];
            }
            parent.word = key;
            parent.isEndOfWord = true;
        }

        /**
         * 寻找单词Key的前缀
         *
         * @param key
         * @return
         */
        public String findRoot(String key) {
            TrieNode parent = root;
            for (int i = 0; i < key.length(); i++) {
                int idx = key.charAt(i) - 'a';

                if (parent.isEndOfWord) {
                    return parent.word;
                } else if (parent.kids[idx] == null) {
                    return key;
                }

                parent = parent.kids[idx];
            }

            return key;
        }
    }
}
