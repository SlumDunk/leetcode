package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 11:11
 * @Description: Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
 * Example:
 * Input:
 * [[0,1,1,0],
 * [0,1,1,0],
 * [0,0,0,1]]
 * Output: 3
 * Hint: The number of elements in the given matrix will not exceed 10,000.
 */
public class Leetcode562 {
    public int longestLine(int[][] M) {
        // we have four directions to check for each 1 in the matrix
        if (M == null || M.length == 0) return 0;
        int m = M.length, n = M[0].length;
        int max = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    int[] temp = new int[4];
                    temp[0] = getConsecutiveOneNum(M, i, j, 1, m, n); // right_down
                    temp[1] = getConsecutiveOneNum(M, i, j, 2, m, n); // right
                    temp[2] = getConsecutiveOneNum(M, i, j, 3, m, n); // down
                    temp[3] = getConsecutiveOneNum(M, i, j, 4, m, n); // left_down
                    Arrays.sort(temp);
                    max = Math.max(max, temp[3]);
                }
            }
        }
        return max;
    }

    /**
     *
     * @param M
     * @param i
     * @param j
     * @param direction 方向
     * @param m
     * @param n
     * @return
     */
    public int getConsecutiveOneNum(int[][] M, int i, int j, int direction, int m, int n) {
        int num = 1;
        switch (direction) {
            case 1://从左上角过来
                if (i - 1 >= 0 && j - 1 >= 0 && M[i - 1][j - 1] == 1) break;
                while (i + 1 < m && j + 1 < n) {
                    if (M[i + 1][j + 1] != 1) break;
                    num++;
                    i++;
                    j++;
                }
                break;
            case 2://从左边过来
                if (j - 1 >= 0 && M[i][j - 1] == 1) break;
                while (j + 1 < n) {
                    if (M[i][j + 1] != 1) break;
                    num++;
                    j++;
                }
                break;
            case 3://从上边过来
                if (i - 1 >= 0 && M[i - 1][j] == 1) break;
                while (i + 1 < m) {
                    if (M[i + 1][j] != 1) break;
                    num++;
                    i++;
                }
                break;
            case 4://从右上角过来
                if (i - 1 >= 0 && j + 1 < n && M[i - 1][j + 1] == 1) break;
                while (i + 1 < m && j - 1 >= 0) {
                    if (M[i + 1][j - 1] != 1) break;
                    num++;
                    i++;
                    j--;
                }
                break;
        }
        return num;
    }
}
