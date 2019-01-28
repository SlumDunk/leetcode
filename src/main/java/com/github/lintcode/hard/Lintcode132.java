package com.github.lintcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 09:46
 * @Description: Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. One character only be used once in one word. No same word in dictionary
 * <p>
 * Example
 * Given matrix:
 * <p>
 * doaf
 * agai
 * dcan
 * and dictionary:
 * <p>
 * {"dog", "dad", "dgdg", "can", "again"}
 * <p>
 * return {"dog", "dad", "can", "again"}
 * <p>
 * <p>
 * dog:
 * doaf
 * agai
 * dcan
 * dad:
 * <p>
 * doaf
 * agai
 * dcan
 * can:
 * <p>
 * doaf
 * agai
 * dcan
 * again:
 * <p>
 * doaf
 * agai
 * dcan
 * Challenge
 * Using trie to implement your algorithm.
 */
public class Lintcode132 {
    //顺时针，上，右，下，左
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};

    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        if (board == null || board.length == 0) {
            return new ArrayList<>();
        }
        if (board[0] == null || board[0].length == 0) {
            return new ArrayList<>();
        }
        //通过字典构造前缀树，前缀树比哈希表更优，时间和空间，还支持前缀查询
        TrieNode root = new TrieNode('1');
        for (String word : words) {
            addWord(word, root);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, root, result);
            }
        }
        return result;
    }

    public void search(char[][] board, int x, int y, TrieNode root, List<String> result) {
        char value = board[x][y];
        if (root.children[value - 'a'] == null) {
            return;
        } else {
            TrieNode child = root.children[value - 'a'];
            if (child.word != null && !result.contains(child.word)) {
                result.add(child.word);
            }
            board[x][y] = 0;
            for (int k = 0; k < 4; k++) {
                if (isValid(x + dx[k], y + dy[k], board)) {
                    search(board, x + dx[k], y + dy[k], child, result);
                } else {
                    continue;
                }
            }
            board[x][y] = value;
        }
    }

    public boolean isValid(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 0) {
            return false;
        }
        return true;
    }

    public void addWord(String word, TrieNode root) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(c);
            }
            current = current.children[c - 'a'];
        }
        current.word = word;

    }

    class TrieNode {
        char val;
        String word;
        TrieNode[] children;

        public TrieNode(char value) {
            val = value;
            children = new TrieNode[26];
        }
    }
}
