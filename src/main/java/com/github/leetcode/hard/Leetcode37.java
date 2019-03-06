package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 10:16
 * @Description: Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 * <p>
 * <p>
 * A sudoku puzzle...
 * <p>
 * <p>
 * ...and its solution numbers marked in red.
 * <p>
 * Note:
 * <p>
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 */
public class Leetcode37 {
    //存储第i行第j个数是否被占用了
    boolean[][] row = new boolean[9][9 + 1];
    //存储第i列第j个数是否被使用了
    boolean[][] col = new boolean[9][9 + 1];
    //存储某一个块中某个数是否被占用了
    boolean[][][] block = new boolean[3][3][9 + 1];

    public void solveSudoku(char[][] board) {
        int i, j, k;
        for (i = 0; i < 9; i++) {
            for (j = 1; j <= 9; j++) {
                row[i][j] = col[i][j] = false;
            }
        }

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                for (k = 1; k <= 9; k++) {
                    block[i][j][k] = false;
                }
            }
        }

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    k = board[i][j] - '0';
                    row[i][k] = col[j][k] = true;
                    block[i / 3][j / 3][k] = true;
                }
            }
        }

        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            solve(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }

        int k;
        for (k = 1; k <= 9; k++) {
            if (!row[i][k] && !col[j][k] && !block[i / 3][j / 3][k]) {
                row[i][k] = col[j][k] = block[i / 3][j / 3][k] = true;
                board[i][j] = (char) ('0' + k);
                if (solve(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
                row[i][k] = col[j][k] = block[i / 3][j / 3][k] = false;
            }
        }
        return false;
    }
}
