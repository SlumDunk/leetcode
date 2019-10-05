package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/13/19 17:01
 * @Description: Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 9
 * Example 2:
 * <p>
 * Input: grid = [[1,1,0,0]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] is 0 or 1
 */
public class Leetcode1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] top = new int[row][col];
        int[][] left = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    top[i][j] = i > 0 ? top[i - 1][j] + 1 : 1;
                    left[i][j] = j > 0 ? left[i][j - 1] + 1 : 1;
                }
            }
        }


        for (int a = Math.min(row, col); a > 0; a--) {
            for (int i = row - 1; i - a + 1 >= 0; i--) {
                for (int j = col - 1; j - a + 1 >= 0; j--) {
                    if (top[i][j] >= a && left[i][j] >= a && left[i - a + 1][j] >= a && top[i][j - a + 1] >= a) {
                        return a * a;
                    }
                }
            }
        }
        return 0;
    }
}
