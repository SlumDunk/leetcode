package com.github.lintcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/15/19 19:16
 * @Description:
 */
public class Lintcode623 {
    /**
     * @param words:  a set of stirngs
     * @param target: a target string
     * @param k:      An integer
     * @return: output all the strings that meet the requirements
     */
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (words == null || target == null || k < 0) {
            return result;
        }
        TrieNode root = new TrieNode(' ');

        for (String word : words) {
//            if (canTransfer(word, target, k)) {
//                result.add(word);
//            }
            buildTree(root, word);
        }
        int len = target.length();
        //当前节点字符转化为字符串target的第j个字符至少需要多少次edition
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = i;
        }
        helper(root, target, result, k, dp);
        return result;
    }

    private void helper(TrieNode node, String target, List<String> result, int k, int[] dp) {
        int len = target.length();
        if (node.isWord && dp[len] <= k) {
            result.add(node.word);
        }
        int[] nextDP = new int[len + 1];
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                nextDP[0] = dp[0] + 1;
                for (int j = 1; j <= len; j++) {
                    if (target.charAt(j - 1) == node.children[i].val) {
                        nextDP[j] = Math.min(dp[j - 1], Math.min(nextDP[j - 1] + 1, dp[j] + 1));
                    } else {
                        nextDP[j] = Math.min(dp[j - 1], Math.min(nextDP[j - 1], dp[j])) + 1;
                    }
                }
                helper(node.children[i], target, result, k, nextDP);
            }
        }
    }

    private void buildTree(TrieNode root, String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char val = word.charAt(i);
            if (currentNode.children[val - 'a'] == null) {
                currentNode.children[val - 'a'] = new TrieNode(val);
            }
            currentNode = currentNode.children[val - 'a'];
        }
        currentNode.isWord = true;
        currentNode.word = word;
    }

    /**
     * 会超时
     *
     * @param word
     * @param target
     * @param k
     * @return
     */
    public boolean canTransfer(String word, String target, int k) {
        if (word.equals(target)) {
            return true;
        }
        if (Math.abs(word.length() - target.length()) > k) {
            return false;
        }
        int m = word.length();
        int n = target.length();
        //word的前i个字符转成target的前j个字符的次数
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]) + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        if (dp[m][n] > k) {
            return false;
        } else {
            return true;
        }
    }


    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
        String word;

        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            this.word = null;
        }
    }


    /**
     * @param words:  a set of stirngs
     * @param target: a target string
     * @param k:      An integer
     * @return: output all the strings that meet the requirements
     */
    public List<String> kDistance__(String[] words, String target, int k) {
        // write your code here
        List<String> resultList = new ArrayList<String>();
        Trie root = new Trie(' ');
        for (String word : words) {
            addWord(root, word);
        }
        this.len = target.length();
        int[] dp = new int[this.len + 1];
        for (int i = 0; i < this.len; i++) {
            dp[i] = i;
        }

        helper(root, target, resultList, k, dp);

        return resultList;
    }

    int len;
    int INF = (int) (1e9 + 7);

    private void helper(Trie node, String target, List<String> resultList, int k, int[] dp) {
        if (node.isWord && dp[this.len] <= k) {
            resultList.add(node.word);
        }
        int[] nextDP = new int[this.len + 1];
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                nextDP[0] = dp[0] + 1;
                for (int j = 1; j <= len; j++) {
                    nextDP[j] = INF;
                    if (target.charAt(j - 1) == node.children[i].val) {
                        nextDP[j] = Math.min(nextDP[j], dp[j - 1]);
                    }
                    //插入
                    nextDP[j] = Math.min(nextDP[j], nextDP[j - 1] + 1);
                    //替换
                    nextDP[j] = Math.min(nextDP[j], dp[j - 1] + 1);
                    //删除
                    nextDP[j] = Math.min(nextDP[j], dp[j] + 1);
                }
                helper(node.children[i], target, resultList, k, nextDP);
            }
        }
    }

    public void addWord(Trie root, String word) {
        Trie current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Trie(c);
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
        current.word = word;
    }

    class Trie {
        char val;
        Trie[] children = new Trie[26];
        boolean isWord = false;
        String word;

        public Trie(char val) {
            this.val = val;
        }
    }
}
