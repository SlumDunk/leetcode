package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/4/19 16:05
 * @Description: Given a set of words (without duplicates), find all word squares you can build from them.
 * <p>
 * A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 * <p>
 * For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.
 * <p>
 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * Note:
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 * <p>
 * Input:
 * ["area","lead","wall","lady","ball"]
 * <p>
 * Output:
 * [
 * [ "wall",
 * "area",
 * "lead",
 * "lady"
 * ],
 * [ "ball",
 * "area",
 * "lead",
 * "lady"
 * ]
 * ]
 * <p>
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 * Example 2:
 * <p>
 * Input:
 * ["abat","baba","atan","atal"]
 * <p>
 * Output:
 * [
 * [ "baba",
 * "abat",
 * "baba",
 * "atan"
 * ],
 * [ "baba",
 * "abat",
 * "baba",
 * "atal"
 * ]
 * ]
 * <p>
 * Explanation:
 * The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
 */
public class Leetcode425 {
    /**
     * Trie树节点
     */
    class Node {
        List<String> list = new ArrayList<>();
        Node[] child = new Node[26];
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> wordSquares(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (Character ch : word.toCharArray()) {
                cur.list.add(word);
                if (cur.child[ch - 'a'] == null) {
                    cur.child[ch - 'a'] = new Node();
                }
                cur = cur.child[ch - 'a'];
            }
        }
        dfs(new ArrayList<>(), root, words[0].length());
        return res;
    }

    /**
     * @param item
     * @param root
     * @param n    单词长度
     */
    void dfs(List<String> item, Node root, int n) {
        // System.out.println("item: " + item);
        if (item.size() == n) {
            res.add(new ArrayList<>(item));
            return;
        }
        List<String> valid = findPre(root, item);
        // System.out.println("valid: " + valid);
        for (String s : valid) {
            item.add(s);
            dfs(item, root, n);
            item.remove(item.size() - 1);
        }
    }

    /**
     * @param root
     * @param item
     * @return
     */
    List<String> findPre(Node root, List<String> item) {
        Node cur = root;
        int size = item.size();
        //每一个单词都有可能成为第一行
        for (String s : item) {
            int idx = s.charAt(size) - 'a';
            if (cur.child[idx] == null) {
                return new ArrayList<String>();
            }
            cur = cur.child[idx];
        }
        return cur.list;
    }
}
