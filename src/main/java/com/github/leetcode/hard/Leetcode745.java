package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/12/19 22:59
 * @Description: Given many words, words[i] has weight i.
 * <p>
 * Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.
 * <p>
 * Examples:
 * <p>
 * Input:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // returns 0
 * WordFilter.f("b", "") // returns -1
 * <p>
 * <p>
 * Note:
 * <p>
 * words has length in range [1, 15000].
 * For each test case, up to words.length queries WordFilter.f may be made.
 * words[i] has length in range [1, 10].
 * prefix, suffix have lengths in range [0, 10].
 * words[i] and prefix, suffix queries consist of lowercase letters only.
 */
public class Leetcode745 {

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        System.out.println(wordFilter.f("a", "e"));
    }

    static class WordFilter {
        /**
         * 前缀树
         */
        private TrieNode m_prefixTrie;
        /**
         * 后缀树
         */
        private TrieNode m_suffixTrie;

        public WordFilter(String[] words) {
            m_prefixTrie = buildPreTrie(words);
            m_suffixTrie = buildSufTrie(words);
        }

        /**
         * 创建前缀树
         *
         * @param words
         * @return
         */
        public TrieNode buildPreTrie(String[] words) {
            TrieNode root = new TrieNode(' ');
            for (int weight = words.length - 1; weight >= 0; weight--) {
                String s = words[weight];
                root.insert(s, weight);
            }
            return root;
        }

        /**
         * 创建后缀树
         *
         * @param words
         * @return
         */
        public TrieNode buildSufTrie(String[] words) {
            TrieNode root = new TrieNode(' ');
            for (int weight = words.length - 1; weight >= 0; weight--) {
                String s = words[weight];
                String reversed = new StringBuilder(s).reverse().toString();
                root.insert(reversed, weight);
            }
            return root;
        }

        /**
         * @param prefix
         * @param suffix
         * @return
         */
        public int f(String prefix, String suffix) {
            List<Integer> w1 = m_prefixTrie.findWeights(prefix);
            List<Integer> w2 = m_suffixTrie.findWeights(new StringBuilder(suffix).reverse().toString());
            if (w1 == null || w2 == null) {
                return -1;
            } else {
                int i = 0;
                int j = 0;
                while (i < w1.size() && j < w2.size()) {
                    int weight1 = w1.get(i);
                    int weight2 = w2.get(j);
                    if (weight1 == weight2) {//属于同一个单词
                        return weight1;
                    } else if (weight1 > weight2) {
                        i++;
                    } else {
                        j++;
                    }
                }
                return -1;
            }
        }
    }

    /**
     * Trie 树节点
     */
    static class TrieNode {
        /**
         * 字符
         */
        public char c;
        /**
         * 子节点
         */
        public Map<Character, TrieNode> children;
        /**
         * 存储字符对应的单词位置索引信息
         */
        public List<Integer> weights;

        TrieNode(char c) {
            this.c = c;
            this.children = new HashMap<Character, TrieNode>();
            this.weights = new ArrayList<Integer>();
        }

        TrieNode(char c, int weight) {
            this.c = c;
            this.children = new HashMap<Character, TrieNode>();
            this.weights = new ArrayList<Integer>();
            weights.add(weight);
        }

        /**
         * 节点插入新的字符串
         *
         * @param s
         * @param weight
         */
        public void insert(String s, int weight) {
            if (null == s || s.length() == 0) {
                return;
            }
            char first = s.charAt(0);
            weights.add(weight);
            TrieNode child = children.get(first);
            if (child == null) {
                child = new TrieNode(first, weight);
                children.put(first, child);
            } else {
                child.weights.add(weight);
            }
            child.insert(s.substring(1), weight);
        }

        /**
         * @param prefix
         * @return
         */
        public List<Integer> findWeights(String prefix) {
            if (null == prefix || prefix.length() == 0) {
                return weights;
            }
            char first = prefix.charAt(0);
            TrieNode child = children.get(first);
            if (child != null) {
                if (prefix.length() == 1) {
                    return child.weights;
                } else {
                    return child.findWeights(prefix.substring(1));
                }
            }
            return null;
        }
    }
}
