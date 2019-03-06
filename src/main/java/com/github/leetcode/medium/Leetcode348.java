package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 16:49
 * @Description: Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * You may assume the following rules:
 * <p>
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * <p>
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * <p>
 * TicTacToe toe = new TicTacToe(3);
 * <p>
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 * <p>
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 * <p>
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 * <p>
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 * <p>
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 * <p>
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 * <p>
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * <p>
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 * <p>
 * Hint:
 * <p>
 * Could you trade extra space such that move() operation can be done in O(1)?
 * You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.
 */
public class Leetcode348 {
    /**
     * 井字棋
     * 每下一步棋判断各自的行状态，列状态，对角线状态，副对角线状态
     */
    class TicTacToe {
        /**
         * 记录两个对手的行状态
         */
        private int[][] rows;
        /**
         * 记录两个对手的列状态
         */
        private int[][] cols;
        /**
         * 记录两个对手的对角线状态
         */
        private int[] diag = new int[2];
        /**
         * 记录两个对手的副对角线状态
         */
        private int[] aDiag = new int[2];

        int size;

        public TicTacToe(int n) {
            rows = new int[n][2];
            cols = new int[n][2];
            size = n;
        }

        /**
         * 下期
         *
         * @param row
         * @param col
         * @param player 1代表棋手1， 2代表棋手2
         * @return
         */
        public int move(int row, int col, int player) {
            //看看走完这一步行状态
            int len = ++rows[row][player - 1];
            if (len == size) return player;

            //看看走完这一步列状态
            len = ++cols[col][player - 1];
            if (len == size) return player;

            //看看主对角线状态
            if (row == col) {
                len = ++diag[player - 1];
                if (len == size) return player;
            }
            //看看副对角线状态
            if (row + col == size - 1) {
                len = ++aDiag[player - 1];
                if (len == size) return player;
            }
            return 0;
        }
    }
}
