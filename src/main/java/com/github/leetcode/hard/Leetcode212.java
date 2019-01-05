package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 21:11
 * @Description: Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Example:
 * <p>
 * Input:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * <p>
 * Output: ["eat","oath"]
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class Leetcode212 {
    //上 右 下 左， 顺时针
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        //根据words构造Trie树
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrieTree(words);
        int row = board.length;
        int col = board[0].length;
        //深度优先遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    /**
     * @param board  要查找的数组
     * @param i      行坐标
     * @param j      列坐标
     * @param root   父节点
     * @param result 结果集
     */
    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return;
        }
        char val = board[i][j];
        //已经访问过或者不存在这样的单词
        if (val == '#' || root.children[val - 'a'] == null) {
            return;
        }
        root = root.children[val - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;//防止重复添加
        }
        //打上访问过的标记
        board[i][j] = '#';
        //顺时针走 上 右 下 左
        for (int[] direction : directions
                ) {
            dfs(board, i + direction[0], j + direction[1], root, result);
        }
        //回溯复位
        board[i][j] = val;
    }

    /**
     * 创建Trie树
     *
     * @param words
     * @return
     */
    private TrieNode buildTrieTree(String[] words) {
        TrieNode root = new TrieNode();

        for (String word :
                words) {
            TrieNode curNode = root;
            for (char val :
                    word.toCharArray()) {
                if (curNode.children[val - 'a'] == null) {
                    curNode.children[val - 'a'] = new TrieNode();
                }
                curNode = curNode.children[val - 'a'];
            }
            curNode.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        //存储节点的单词值
        String word;
    }
}
