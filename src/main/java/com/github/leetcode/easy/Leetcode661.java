package com.github.leetcode.easy;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.
 * <p>
 * Example 1:
 * Input:
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * Output:
 * [[0, 0, 0],
 * [0, 0, 0],
 * [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 */
public class Leetcode661 {
    public static void main(String[] args) {
        Leetcode661 leetcode661 = new Leetcode661();
        int[][] M = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        leetcode661.imageSmoother(M);

    }

    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = M[i][j];
                int count = 1;
                //注意边界问题
                //按顺时针走
                if (i - 1 >= 0) {//正上
                    sum += M[i - 1][j];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < col) {//右上
                    sum += M[i - 1][j + 1];
                    count++;
                }
                if (j + 1 < col) {//正右
                    sum += M[i][j + 1];
                    count++;
                }
                if (j + 1 < col && i + 1 < row) {//右下
                    sum += M[i + 1][j + 1];
                    count++;
                }
                if (i + 1 < row) {//正下
                    sum += M[i + 1][j];
                    count++;
                }
                if (i + 1 < row && j - 1 >= 0) {//左下
                    sum += M[i + 1][j - 1];
                    count++;
                }
                if (j - 1 >= 0) {//正左
                    sum += M[i][j - 1];
                    count++;
                }
                if (j - 1 >= 0 && i - 1 >= 0) {//左上
                    sum += M[i - 1][j - 1];
                    count++;
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
}
