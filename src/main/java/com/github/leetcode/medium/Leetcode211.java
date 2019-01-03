package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 16:43
 * @Description: Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
public class Leetcode211 {
    /**
     * 字典树类Trie
     */
    public class WordDictionary {
        /**
         * 字典树根节点
         */
        private TrieNode root = new TrieNode();

        /**
         * 往字典里投添加单词
         *
         * @param word
         */
        public void addWord(String word) {
            TrieNode curNode = root;
            for (char value : word.toCharArray()) {
                if (curNode.children[value - 'a'] == null) {
                    curNode.children[value - 'a'] = new TrieNode(value);
                }
                curNode = curNode.children[value - 'a'];
            }
            curNode.isLeaf = true;
        }

        /**
         * 从根节点开始查找单词
         *
         * @param word
         * @return
         */
        public boolean search(String word) {
            return searchNode(word, root);
        }

        /**
         * 查找单词
         *
         * @param word    要查找的字符串
         * @param curNode 父级节点
         * @return
         */
        public boolean searchNode(String word, TrieNode curNode) {
            if (curNode == null) return false;
            if (word.length() == 0) return curNode.isLeaf;

            char c = word.charAt(0);
            //通配符，可以匹配所有的字符
            if (c == '.') {
                //遍历当前节点的所有子节点,有一个匹配即可
                for (TrieNode child : curNode.children) {
                    if (searchNode(word.substring(1), child)) return true;
                }
                return false;
            } else if (curNode.children[c - 'a'] == null) {
                return false;
            } else {
                curNode = curNode.children[c - 'a'];
                return searchNode(word.substring(1), curNode);
            }
        }
    }

    /**
     * 字典树节点
     */
    class TrieNode {
        /**
         * 节点存储的字符
         */
        char value;
        /**
         * 是否叶子节点
         */
        boolean isLeaf;
        /**
         * 子节点
         */
        TrieNode[] children;

        public TrieNode() {

        }

        public TrieNode(char value) {
            this.value = value;
        }
    }
}
