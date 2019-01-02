package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 15:56
 * @Description: Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Example:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 * <p>
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Leetcode208 {
    /**
     * Trie树节点
     */
    class TrieNode {
        /**
         * 存储子节点
         */
        TrieNode[] children = new TrieNode[26];
        /**
         * 叶子节点存储单词的值
         */
        String val = "";

        public TrieNode() {

        }
    }

    /**
     * Trie字典树
     */
    public class Trie {
        /**
         * 树的根节点
         */
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入一个单词进入Trie树
         *
         * @param word
         */
        public void insert(String word) {
            TrieNode curNode = this.root;
            for (char c : word.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    curNode.children[c - 'a'] = new TrieNode();
                }
                //更新当前节点
                curNode = curNode.children[c - 'a'];
            }
            //走到叶子节点，赋予单词的值
            curNode.val = word;

        }

        /**
         * 查找字典里是否存在单词word
         *
         * @param word
         * @return
         */
        public boolean search(String word) {
            TrieNode curNode = this.root;
            for (char c : word.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    return false;
                }
                curNode = curNode.children[c - 'a'];
            }
            //走到最后节点，查看节点值是否等于单词值
            return curNode.val.equals(word);
        }

        /**
         * 查找是否有指定前缀的单词
         *
         * @param prefix
         * @return
         */
        public boolean startsWith(String prefix) {
            TrieNode curNode = this.root;
            for (char c : prefix.toCharArray()) {
                if (curNode.children[c - 'a'] == null) {
                    return false;
                }
                curNode = curNode.children[c - 'a'];
            }
            return true;
        }

    }
}
