package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 15:05
 * @Description: Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class Leetcode498 {
    public static void main(String[] args) {
        Leetcode498 leetcode498 = new Leetcode498();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        leetcode498.findDiagonalOrder(matrix);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[]{};
        }
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        boolean down = false;
        //x+y=code, code 从 0 到 （m-1)+(n-1)
        for (int code = 0, x = 0; code <= ((m - 1) + (n - 1)); code++) {
            //每个Loop开始点的x index
            int i = x;
            //边界检查
            while ((!down && i >= 0 && code - i < n) || (down && i < m && code - i >= 0)) {
                result[index++] = matrix[i][code - i];
                i = down ? i + 1 : i - 1;
            }
            x = down ? Math.min(i, m - 1) : (code - i < n) ? 0 : i + 2;
            down = down ? false : true;
        }
        return result;

    }
}
