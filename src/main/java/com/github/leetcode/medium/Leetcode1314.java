package com.github.leetcode.medium;

/**
 * Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
 * <p>
 * i - k <= r <= i + k,
 * j - k <= c <= j + k, and
 * (r, c) is a valid position in the matrix.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[12,21,16],[27,45,33],[24,39,28]]
 * Example 2:
 * <p>
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
 * Output: [[45,45,45],[45,45,45],[45,45,45]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, k <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Leetcode1314 {

    /**
     * O(mn)
     * @param mat
     * @param k
     * @return
     */
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // 前 i*j 个数形成的矩阵的和
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m, i + k + 1);
                int c1 = Math.max(0, j - k);
                int c2 = Math.min(n, j + k + 1);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r1][c2] - rangeSum[r2][c1] + rangeSum[r1][c1];
            }
        }
        return ans;
    }
}
