package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 14:06
 * @Description: Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return null;
        }

        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1;
        // 取到‘=’是因为走过的已经移动指针
        while (up <= down && left <= right) {
            // Traverse Right(→)
            for (int j = left; j <= right; j++) {
                matrix[up][j] = num;
                num++;
            }
            up++;

            // Traverse Down(↓)
            for (int j = up; j <= down; j++) {
                matrix[j][right] = num;
                num++;
            }
            right--;

            if (up <= down) {
                // Traverse Left(←)
                for (int j = right; j >= left; j--) {
                    matrix[down][j] = num;
                    num++;
                }
            }
            down--;

            if (left <= right) {
                // Traver Up(↑)
                for (int j = down; j >= up; j--) {
                    matrix[j][left] = num;
                    num++;
                }
            }
            left++;
        }

        return matrix;
    }
}
