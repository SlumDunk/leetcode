package com.github.leetcode.easy;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * <p>
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 * Explanation:
 * The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2:
 * Input:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * Output: "apple"
 * Explanation:
 * Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 * Note:
 * <p>
 * All the strings in the input will only contain lowercase letters.
 * The length of words will be in the range [1, 1000].
 * The length of words[i] will be in the range [1, 30].
 */
public class Leetcode720 {
    public String longestWord(String[] words) {
        //由某一个单词开始，每次增加一个字符，走到长度最长的一个单词
        //构造根节点
        TrieNode root = new TrieNode(' ');
        //构造树
        for (int i = 0; i < words.length; i++) {
            buildTree(root, words[i]);
        }
        //符合条件的最长字符串长度
        int max = 0;
        //符合条件的最长字符串对应数组位置
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            boolean flag = findWord(root, words[i]);
            if (flag && words[i].length() > max) {
                max = words[i].length();
                index = i;
            } else if (flag && words[i].length() == max) {//若长度一致，取字典排序小的
                index = words[i].compareTo(words[index]) > 0 ? index : i;
            }
        }
        return words[index];
    }

    /**
     * 判断是否能找到如何条件的单词
     *
     * @param root
     * @param word
     * @return
     */
    private boolean findWord(TrieNode root, String word) {
        for (char value : word.toCharArray()) {
            if (root.children[value - 'a'] == null) {
                return false;
            }
            root = root.children[value - 'a'];
            //子串必须单独成一个单词
            if (!root.isWord) {
                return false;
            }
        }
        return true;
    }

    /**
     * 构建树
     *
     * @param root 根节点
     * @param str  字符串
     */
    private void buildTree(TrieNode root, String str) {
        for (char value : str.toCharArray()) {
            if (root.children[value - 'a'] == null) {
                root.children[value - 'a'] = new TrieNode(value);
            }
            root = root.children[value - 'a'];
        }
        root.isWord = true;
    }

    /**
     * 字典树的节点
     */
    class TrieNode {
        /**
         * 节点字符值
         */
        char val;
        /**
         * 子节点数组
         */
        TrieNode[] children;
        /**
         * 是否是单词尽头字符
         */
        boolean isWord;

        TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
            isWord = false;
        }

    }
}

