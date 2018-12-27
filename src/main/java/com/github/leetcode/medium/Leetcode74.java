package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/23/18 20:22
 * @Description: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //像一维数组的二分查找一样
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        //保证两个元素的时候左右元素都能被取到，需要=号
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = matrix[mid / n][mid % n];//转化为二维数组中对应的位置指针
            if (target == tmp) {
                return true;
            } else if (target < tmp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
