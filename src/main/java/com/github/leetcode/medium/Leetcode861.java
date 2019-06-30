package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/28/19 22:30
 * @Description: We have a two dimensional matrix A where each value is 0 or 1.
 * <p>
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 * <p>
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 * <p>
 * Return the highest possible score.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 */
public class Leetcode861 {
    /**
     * //0 0 1 1-》1 1 0 0-》1 1 1 1
     * //1 0 1 0-》1 0 1 0-》1 0 0 1
     * //1 1 0 0-》1 1 0 0-》1 1 1 1
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        // left most bit most important, so flip all the rows that aren't starting with 1
        for (int r = 0; r < A.length; r++) {
            if (A[r][0] != 1) flipRow(A, r);
        }

        // flip cols that have more zeros than ones, and skil col 0 because they all should be 1s
        for (int c = 1; c < A[0].length; c++) {
            int zerosInCol = 0;
            for (int r = 0; r < A.length; r++) {
                if (A[r][c] == 0) zerosInCol++;
            }
            //超过半数是0， 翻转
            if (zerosInCol > Math.ceil(A.length / 2)) flipColumn(A, c);
        }

        // Count up the binary representations
        int sum = 0;
        for (int[] row : A) {
            sum += arrBinaryToDecimal(row);
        }

        return sum;
    }

    /**
     * 翻转指定列
     *
     * @param A
     * @param c
     * @return
     */
    private int[][] flipColumn(int[][] A, int c) {
        for (int i = 0; i < A.length; i++) {
            A[i][c] = A[i][c] == 0 ? 1 : 0;
        }
        return A;
    }

    /**
     * 翻转指定行
     *
     * @param A
     * @param r
     * @return
     */
    private int[][] flipRow(int[][] A, int r) {
        for (int i = 0; i < A[0].length; i++) {
            A[r][i] = A[r][i] == 0 ? 1 : 0;
        }
        return A;
    }

    /**
     * 每行转成 十进制数
     * 1 1 1 1
     * 2 6 14 30
     * @param b
     * @return
     */
    private int arrBinaryToDecimal(int[] b) {
        int sum = 0;
        for (int i = 0; i < b.length; ++i) {
            sum += b[i];
            sum = sum << 1;
        }
        return sum / 2;
    }
}
