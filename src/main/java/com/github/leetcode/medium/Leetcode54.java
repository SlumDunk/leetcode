package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 10:48
 * @Description: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        // 取到‘=’是因为走过的已经移动指针
        while (up <= down && left <= right) {
            // Traverse Right(→)
            for (int j = left; j <= right; j++) {
                res.add(matrix[up][j]);
            }
            up++;

            // Traverse Down(↓)
            for (int j = up; j <= down; j++) {
                res.add(matrix[j][right]);
            }
            right--;

            if (up <= down) {
                // Traverse Left(←)
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
            }
            down--;

            if (left <= right) {
                // Traver Up(↑)
                for (int j = down; j >= up; j--) {
                    res.add(matrix[j][left]);
                }
            }
            left++;
        }

        return res;
    }
}
