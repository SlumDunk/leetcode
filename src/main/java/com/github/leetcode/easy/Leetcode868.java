package com.github.leetcode.easy;

/**
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * <p>
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 */
public class Leetcode868 {
    public static void main(String[] args) {
        int[][] sourceMatrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] newMatrix = transpose(sourceMatrix);
        System.out.println(newMatrix);
    }

    /**
     * transpose a matrix
     *
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {
        if (A != null && A.length > 0) {
            int rowLength = A.length;
            int columnLength = A[0].length;
            int[][] newMatrix = new int[A[0].length][A.length];
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < columnLength; j++) {
                    newMatrix[j][i] = A[i][j];
                }
            }
            return newMatrix;
        } else {
            return null;
        }
    }
}
