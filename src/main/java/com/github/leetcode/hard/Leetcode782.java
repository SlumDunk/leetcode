package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 22:30
 * @Description: An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.
 * <p>
 * What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.
 * <p>
 * Examples:
 * Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * Output: 2
 * Explanation:
 * One potential sequence of moves is shown below, from left to right:
 * <p>
 * 0110     1010     1010
 * 0110 --> 1010 --> 0101
 * 1001     0101     1010
 * 1001     0101     0101
 * <p>
 * The first move swaps the first and second column.
 * The second move swaps the second and third row.
 * <p>
 * <p>
 * Input: board = [[0, 1], [1, 0]]
 * Output: 0
 * Explanation:
 * Also note that the board with 0 in the top left corner,
 * 01
 * 10
 * <p>
 * is also a valid chessboard.
 * <p>
 * Input: board = [[1, 0], [1, 0]]
 * Output: -1
 * Explanation:
 * No matter what sequence of moves you make, you cannot end with a valid chessboard.
 * Note:
 * <p>
 * board will have the same number of rows and columns, a number in the range [2, 30].
 * board[i][j] will be only 0s or 1s.
 */
public class Leetcode782 {
    /**
     * Intuition:
     * Two conditions to help solve this problem:
     * <p>
     * In a valid chess board, there are 2 and only 2 kinds of rows and one is inverse to the other.
     * For example if there is a row 01010011 in the board, any other row must be either 01010011 or 10101100.
     * The same for columns
     * A corollary is that, any rectangle inside the board with corners top left, top right, bottom left, bottom right must be 4 zeros or 2 ones 2 zeros or 4 zeros.
     * <p>
     * Another important property is that every row and column has half ones. Assume the board is N * N:
     * If N = 2*K, every row and every column has K ones and K zeros.
     * If N = 2*K + 1, every row and every column has K ones and K + 1 zeros or K + 1 ones and K zeros.
     * <p>
     * <p>
     * Explanation:
     * Since the swap process does not break this property, for a given board to be valid, this property must hold.
     * These two conditions are necessary and sufficient condition for a valid chessboard.
     * <p>
     * Once we know it is a valid cheese board, we start to count swaps.
     * Basic on the property above, when we arange the first row, we are actually moving all columns.
     * <p>
     * I try to arrange one row into 01010 and 10101 and I count the number of swaps.
     * <p>
     * In case of N even, I take the minimum swaps, because both are possible.
     * In case of N odd, I take the even swaps.
     * Because when we make a swap, we move 2 columns or 2 rows at the same time.
     * So col swaps and row swaps should be same here.
     * <p>
     * Time Complexity:
     * O(N^2) to check the whole board.
     *
     * @param board
     * @return
     */
    public int movesToChessboard(int[][] board) {
        int N = board.length, rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) return -1;
        for (int i = 0; i < N; ++i) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) rowSwap++;
            if (board[0][i] == i % 2) colSwap++;
        }
        if (rowSum != N / 2 && rowSum != (N + 1) / 2) return -1;
        if (colSum != N / 2 && colSum != (N + 1) / 2) return -1;
        if (N % 2 == 1) {
            if (colSwap % 2 == 1) colSwap = N - colSwap;
            if (rowSwap % 2 == 1) rowSwap = N - rowSwap;
        } else {
            colSwap = Math.min(N - colSwap, colSwap);
            rowSwap = Math.min(N - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }
}
