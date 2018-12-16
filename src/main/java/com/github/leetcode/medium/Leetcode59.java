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
        int[][] matrix = new int[n][n];
        //回字形从最外圈走到最里圈
        //从左上角走到右上角，从右上角走到右下角，从右下角走到左下角，从左下角走到左上角
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int currentItem = 1;
        while (left <= right && up <= down) {
            //左上角走到右上角
            for (int i = left; i <= right; i++) {
                matrix[up][i] = currentItem;
                currentItem++;
            }
            //右上角走到右下角，拐角重复元素去掉
            for (int i = up + 1; i <= down; i++) {
                matrix[i][right] = currentItem;
                currentItem++;
            }
            //右下角走到左下角，拐角重复元素去掉
            if (down > up) {//排除单行的情况
                for (int i = right - 1; i >= left; i--) {
                    matrix[down][i] = currentItem;
                    currentItem++;
                }
            }
            //左下角走到左上角，拐角重复元素去掉
            if (right > left) {//排除单列的情况
                for (int i = down - 1; i > up; i--) {
                    matrix[i][left] = currentItem;
                    currentItem++;
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return matrix;
    }
}
