package com.github.interview.amazon;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 16:32
 * @Description: You are gonna climb mountains represented by a matrix. Each integer in the matrix represents the
 * altitude at that point. You are supposed to climb from the top-left corner to the bottom-right corner
 * and only move rightward or downward in each step.
 * You can have many paths to do so. Each path has a minimum altitude. Find the maximum among all
 * the minimum altitudes of all paths.
 * e.g.
 * 5 4 5 1 3 6
 * Three paths: 5 1 3 6，5 4 3 6，5 4 5 6. Minimums are 1, 3, 4 respectively. Return the maximum in
 * them which is 4.
 * <p>
 * [8, 4, 7]
 * [6, 5, 9]
 * 3 paths：
 * 8-4-7-9 min: 4
 * 8-4-5-9 min: 4
 * 8-6-5-9 min: 5
 * return: 5
 */
public class MaximumMiniumPath {
    public int helper(int[][] matrix) {
        int[] result = new int[matrix[0].length];
        result[0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            result[i] = Math.min(result[i - 1], matrix[0][i]);
        }

        for (int i = 1; i < matrix.length; i++) {
            result[0] = Math.min(matrix[i][0], result[0]);
            for (int j = 1; j < matrix[0].length; j++) {
                result[j] = (result[j] < matrix[i][j] && result[j - 1] < matrix[i][j]) ?
                        Math.max(result[j - 1], result[j]) : matrix[i][j];
            }
        }
        return result[result.length - 1];
    }
}
