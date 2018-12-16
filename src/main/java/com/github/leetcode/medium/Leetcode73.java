package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 19:56
 * @Description: Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        //如果matrix[i][j]==0,那么设置matrix[0][j]=0,matrix[i][0]=0
        int row = matrix.length, cols = matrix[0].length;
        boolean colFlag = false, rowFlag = false;
        for (int i = 0; i < row; i++) {
            if (matrix[row][0] == 0) {//首列有元素是0
                colFlag = true;
            }
            for (int j = 0; j < cols; j++) {
                if (i == 0 && matrix[i][j] == 0) {//首行有元素是0
                    rowFlag = true;
                }
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //从右下角往左上角扫描如果matrix[0][j]或者matrix[i][0]=0, 那么设置matrix[i][j]=0,
        //首行首列需做特殊处理
        for (int i = row - 1; i > 0; i--) {
            for (int j = cols - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //处理首行首列
        if (colFlag == true) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowFlag == true) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
