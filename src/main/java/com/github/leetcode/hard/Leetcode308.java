package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 15:49
 * @Description: Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * <p>
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.
 * <p>
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * update(3, 2, 2)
 * sumRegion(2, 1, 4, 3) -> 10
 * <p>
 * Note:
 * <p>
 * The matrix is only modifiable by the update function.
 * You may assume the number of calls to update and sumRegion function is distributed evenly.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class Leetcode308 {
    public class NumMatrix {
        /**
         * 树状数组,下标从1开始
         */
        private int[][] bitArr;
        /**
         * 原数组
         */
        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
            this.bitArr = new int[matrix.length + 1][matrix[0].length + 1];
            this.matrix = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    update(i, j, matrix[i][j]);
                }
            }
        }

        /**
         * 更新某个位置的值
         *
         * @param row 行位置
         * @param col 列位置
         * @param val
         */
        public void update(int row, int col, int val) {
            if (matrix == null) return;
            int adjust = val - matrix[row][col];
            matrix[row][col] = val;
            row++;
            col++;
            int i = row;
            //自左向右走 更新树状数组
            while (i < bitArr.length) {
                int j = col;
                while (j < bitArr[i].length) {
                    bitArr[i][j] += adjust;
                    //求lowbit j
                    j += (j & -j);
                }
                i += (i & -i);
            }
        }

        /**
         * 求(0,0)到(row,col)的和
         *
         * @param row
         * @param col
         * @return
         */
        private int sum(int row, int col) {
            row++;
            col++;
            int sum = 0;
            int i = row;
            //从右向左走
            while (i > 0) {
                int j = col;
                while (j > 0) {
                    sum += bitArr[i][j];
                    j -= (j & -j);
                }
                i -= (i & -i);
            }
            return sum;
        }

        /**
         * 求区域的面积
         *
         * @param row1
         * @param col1
         * @param row2
         * @param col2
         * @return
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (matrix == null) return 0;
            return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1);
        }
    }

}
