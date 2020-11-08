package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 09:13
 * @Description: According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 1:0,1->0
 * Any live cell with two or three live neighbors lives on to the children generation.
 * 1:2,3->1
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * 1:>3->0
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 0:3->1
 * Write a function to compute the children state (after one update) of the board given its current state. The children state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class Leetcode289 {
    private int countLiveNeigh(int[][] board, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == row && j == col)
                    continue;
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && (board[i][j] == 1 || board[i][j] == 2))//最开始状态为1的
                    count++;
            }
        }
        return count;
    }

    /**
     * O(n)
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = countLiveNeigh(board, i, j);
                if (count == 2) {//相邻存活数量为2,保持本身不变

                } else if (count == 3) {//相邻存活数量为3，且本身为0的，变为3，本身为1的，保持1不变
                    board[i][j] = board[i][j] == 0 ? 3 : 1;
                } else {//相邻存活数量少于2，超过3的，且本身为1的，变为2，本身为0的保持0不变
                    board[i][j] = board[i][j] == 1 ? 2 : 0;
                }
            }
        }

        //利用奇偶和余数性质
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
