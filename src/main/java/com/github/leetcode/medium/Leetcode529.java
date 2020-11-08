package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/23/19 14:19
 * @Description: Let's play the minesweeper game (Wikipedia, online game)!
 * <p>
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 * <p>
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 * <p>
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 */
public class Leetcode529 {

    int[][] directs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    /**
     * O(8*mn)
     *
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    /**
     * @param board
     * @param row
     * @param col
     */
    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return;
        } else if (board[row][col] == 'B') {
            return;
        } else {//'E'
            int mines = 0;
            for (int[] direct : directs) {
                int r = row + direct[0];
                int c = col + direct[1];
                if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                    if (board[r][c] == 'M' || board[r][c] == 'X') {
                        mines += 1;
                    }
                }
            }
            if (mines > 0) {
                board[row][col] = (char) ('0' + mines);
            } else {
                board[row][col] = 'B';
                for (int[] direction : directs) {
                    int r = row + direction[0];
                    int c = col + direction[1];
                    dfs(board, r, c);
                }
            }
        }
    }
}
