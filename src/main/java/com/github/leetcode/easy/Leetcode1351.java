package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 17:34
 * @Description: Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.
 * <p>
 * Return the number of negative numbers in grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 * <p>
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 * <p>
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 * <p>
 * Input: grid = [[-1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class Leetcode1351 {
    public int countNegatives(int[][] grid) {
        int count_negative = 0;
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            count = binarySearch(grid, i);
            count_negative += count;
        }
        return count_negative;
    }

    private int binarySearch(int[][] grid, int i) {
        int lo = 0;
        int hi = grid[i].length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (grid[i][mid] < 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (grid[i][lo] >= 0) {
            return 0;
        }

        return grid[i].length - lo;
    }
}
