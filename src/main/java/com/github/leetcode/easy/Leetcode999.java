package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 10:12
 * @Description: On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.  These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces, and lowercase characters represent black pieces.
 * <p>
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 * <p>
 * Return the number of pawns the rook can capture in one move.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation:
 * Bishops are blocking the rook to capture any pawn.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * The rook can capture the pawns at positions b5, d6 and f5.
 * <p>
 * <p>
 * Note:
 * <p>
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 */
public class Leetcode999 {
    public int numRookCaptures(char[][] board) {
        int iRook = 0, jRook = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'R') {
                    iRook = i;
                    jRook = j;
                }
            }
        }

        int countPawns = 0;

        //down
        if (iRook != board.length) {
            for (int i = iRook + 1; i < 8; i++) {
                if (board[i][jRook] == 'B') {
                    break;
                } else if (board[i][jRook] == 'p') {
                    countPawns++;
                    break;
                }
            }
        }

        //up
        if (iRook != 0) {
            for (int i = iRook - 1; i > 0; i--) {
                if (board[i][jRook] == 'B') {
                    break;
                } else if (board[i][jRook] == 'p') {
                    countPawns++;
                    break;
                }
            }
        }

        //right
        if (jRook != board.length) {
            for (int j = jRook + 1; j < 8; j++) {
                if (board[iRook][j] == 'B')
                    break;
                else if (board[iRook][j] == 'p') {
                    countPawns++;
                    break;
                }
            }
        }
        //left
        if (jRook != 0) {
            for (int j = jRook - 1; j > 0; j--) {
                if (board[iRook][j] == 'B')
                    break;
                else if (board[iRook][j] == 'p') {
                    countPawns++;
                    break;
                }
            }
        }
        return countPawns;
    }
}
