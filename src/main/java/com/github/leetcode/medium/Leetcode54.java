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
        //回字形从最外圈走到最里圈
        //从左上角走到右上角，从右上角走到右下角，从右下角走到左下角，从左下角走到左上角
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        while (left <= right && up <= down) {
            //左上角走到右上角
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            //右上角走到右下角，拐角重复元素去掉
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            //右下角走到左下角，拐角重复元素去掉
            if (down > up) {//排除单行的情况
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[down][i]);
                }
            }
            //左下角走到左上角，拐角重复元素去掉
            if (right > left) {//排除单列的情况
                for (int i = down - 1; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
