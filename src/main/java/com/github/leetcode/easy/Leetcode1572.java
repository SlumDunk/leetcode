package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 17:19
 * @Description: Given a square matrix mat, return the sum of the matrix diagonals.
 * <p>
 * Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * Output: 25
 * Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
 * Notice that element mat[1][1] = 5 is counted only once.
 * Example 2:
 * <p>
 * Input: mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * Output: 8
 * Example 3:
 * <p>
 * Input: mat = [[5]]
 * Output: 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == mat.length == mat[i].length
 * 1 <= n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Leetcode1572 {
    public int diagonalSum(int[][] mat) {
        int start = 0;
        int end = mat.length - 1;
        int sum = 0;
        while (start < mat.length && end >= 0) {
            sum += (mat[start][start] + mat[end][start]);
            start++;
            end--;
        }
        if (mat.length % 2 == 1) {
            return sum - mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }
}
