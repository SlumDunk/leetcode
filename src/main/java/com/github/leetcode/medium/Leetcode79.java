package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 22:18
 * @Description: Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class Leetcode79 {
    int[] dh = {0, 1, 0, -1};  //检索方向[右,下,左,上]
    int[] dw = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];  //访问标记
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (backTrack(board, word, i, j, 0, isVisited)) return true;
        return false;
    }

    /**
     * @param board     数组
     * @param word      单词
     * @param row       开始行
     * @param column    开始列
     * @param index     单词字符索引
     * @param isVisited 标记数组 true为访问过 false为未访问
     * @return
     */
    public boolean backTrack(char[][] board, String word, int row, int column, int index, boolean[][] isVisited) {
        //行或列越界或者当前字符不等于目标单词index位置的字符或者该位置字符已经访问过
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
                || isVisited[row][column] || board[row][column] != word.charAt(index))
            return false;  //剪枝
        //word所有字符均匹配上
        if (index == word.length() - 1) return true;
        index++;
        //设置该位置已经访问
        isVisited[row][column] = true;
        for (int i = 0; i < 4; i++)
            if (backTrack(board, word, row + dh[i], column + dw[i], index, isVisited))
                return true;  //以board[row][column]为起点找到匹配上word路径
        //遍历过后，将该点还原为未访问过
        isVisited[row][column] = false;
        return false;
    }

    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * O(m*n*4^k) k为最大的递归深度，为word的长度
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist_(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(board, word, i, j, 0, visited)) return true;
            }
        }

        return false;
    }

    public boolean helper(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || visited[row][col] || board[row][col] != word.charAt(index))
            return false;
        if (index == word.length() - 1) return true;

        index++;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            if (helper(board, word, row + dir[0], col + dir[1], index, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
