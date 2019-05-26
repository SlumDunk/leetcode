package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 14:18
 * @Description: A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
 * <p>
 * The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.
 * <p>
 * Here are the rules of Tic-Tac-Toe:
 * <p>
 * Players take turns placing characters into empty squares (" ").
 * The first player always places "X" characters, while the second player always places "O" characters.
 * "X" and "O" characters are always placed into empty squares, never filled ones.
 * The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Example 1:
 * Input: board = ["O  ", "   ", "   "]
 * Output: false
 * Explanation: The first player always plays "X".
 * <p>
 * Example 2:
 * Input: board = ["XOX", " X ", "   "]
 * Output: false
 * Explanation: Players take turns making moves.
 * <p>
 * Example 3:
 * Input: board = ["XXX", "   ", "OOO"]
 * Output: false
 * <p>
 * Example 4:
 * Input: board = ["XOX", "O O", "XOX"]
 * Output: true
 * Note:
 * <p>
 * board is a length-3 array of strings, where each string board[i] has length 3.
 * Each board[i][j] is a character in the set {" ", "X", "O"}.
 */
public class Leetcode794 {
    public boolean validTicTacToe(String[] board) {
        int N = board.length;
        int[] row = new int[N];
        int[] col = new int[N];

        int diag = 0;
        int antiDiag = 0;
        // X
        int first = 0;
        // O
        int second = 0;

        int i, j;

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                int val = boardVal(board[i].charAt(j));
                first += val == 1 ? 1 : 0;
                second += val == -1 ? 1 : 0;
            }
        }
        //相等或相差1
        if (first != second && first - second != 1) {
            return false;
        }
        //检查行
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                row[i] += boardVal(board[i].charAt(j));
            }
            if (!checkWinner(row[i], first, second, N)) {
                return false;
            }
        }
        //检查列
        for (j = 0; j < N; j++) {
            for (i = 0; i < N; i++) {
                col[j] += boardVal(board[i].charAt(j));
            }
            if (!checkWinner(col[j], first, second, N)) {
                return false;
            }
        }
        //检查主副对角线
        for (i = 0; i < N; i++) {
            diag += boardVal(board[i].charAt(i));
            antiDiag += boardVal(board[i].charAt(N - i - 1));
        }
        if (!checkWinner(diag, first, second, N) || !checkWinner(antiDiag, first, second, N)) {
            return false;
        }

        return true;
    }

    private boolean checkWinner(int val, int first, int second, int N) {
        if (val == N) {//这一步下X
            return first - second == 1;
        } else if (val == -N) {//这一步下O
            return first == second;
        }
        return true;
    }

    private int boardVal(char c) {
        if (c == 'X') {
            return 1;
        } else if (c == 'O') {
            return -1;
        }
        return 0;
    }
}
