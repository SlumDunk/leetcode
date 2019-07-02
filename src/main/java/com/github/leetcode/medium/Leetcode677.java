package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 19:47
 * @Description: Implement a MapSum class with insert, and sum methods.
 * <p>
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 * <p>
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 * <p>
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class Leetcode677 {

    /**
     * Trie树节点
     */
    class TrieNode {
        public Map<Character, TrieNode> children;
        private int value;

        public TrieNode() {
            children = new HashMap<>();
        }

        public void setValue(int val) {
            value = val;
        }

        public int getValue() {
            return value;
        }

        public TrieNode get(char ch) {
            return children.get(ch);
        }

        public void put(char ch, TrieNode node) {
            children.put(ch, node);
        }

    }

    class MapSum {

        TrieNode root;

        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            char[] chars = key.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (node.get(aChar) == null) {
                    node.put(aChar, new TrieNode());
                }
                node = node.get(aChar);
            }
            //把值设进去
            node.setValue(val);
        }

        public int sum(String prefix) {
            TrieNode target = searchPrefix(prefix);
            if (target == null) return 0;
            return getSum(target);
        }

        /**
         * 找到子节点的和
         *
         * @param node
         * @return
         */
        private int getSum(TrieNode node) {
            if (node == null) return 0;
            Map<Character, TrieNode> children = node.children;
            int res = node.getValue();
            for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
                int val = getSum(entry.getValue());
                res = res + val;
            }
            return res;
        }

        /**
         * 找到节点
         *
         * @param prefix
         * @return
         */
        private TrieNode searchPrefix(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (node.get(aChar) == null) return null;
                node = node.get(aChar);
            }
            return node;
        }
    }
}
