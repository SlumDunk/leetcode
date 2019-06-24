package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 21:16
 * @Description: Implement the StreamChecker class as follows:
 * <p>
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.
 * <p>
 * <p>
 * Example:
 * <p>
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 */
public class Leetcode1032 {

    class StreamChecker {

        private Node root;
        private StringBuilder sb;

        public StreamChecker(String[] words) {
            root = new Node();
            sb = new StringBuilder();
            build(words);
        }

        public boolean query(char letter) {
            sb.append(letter);
            return findWord();
        }

        /**
         * 找单词
         *
         * @return
         */
        private boolean findWord() {
            Node node = root;
            //从newest 到 oldest
            for (int i = sb.length() - 1; i >= 0; i--) {
                char ch = sb.charAt(i);
                if (node.child[ch - 'a'] == null) {
                    return false;
                }
                node = node.child[ch - 'a'];
                if (node.end) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 构建Trie树
         *
         * @param words
         */
        private void build(String[] words) {
            for (String word : words) {
                Node node = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char ch = word.charAt(i);
                    if (node.child[ch - 'a'] == null) {
                        node.child[ch - 'a'] = new Node();
                    }
                    node = node.child[ch - 'a'];
                }
                node.end = true;
            }
        }

        /**
         * node of Trie tree
         */
        private class Node {
            Node[] child = new Node[26];
            boolean end = false;
        }
    }

}
