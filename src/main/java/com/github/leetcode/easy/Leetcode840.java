package com.github.leetcode.easy;

/**
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * <p>
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * <p>
 * while this one is not:
 * 384
 * 519
 * 762
 * <p>
 * In total, there is only one magic square inside the given grid.
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 */
public class Leetcode840 {
    public static void main(String[] args) {
        Leetcode840 leetcode840 = new Leetcode840();
        int[][] grid = {{4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}};
        leetcode840.numMagicSquaresInside(grid);
    }

    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (magicHelper(i, j, grid))
                    res++;
            }
        }
        return res;
    }

    private boolean magicHelper(int x, int y, int[][] grid) {
        if (grid[x + 1][y + 1] != 5) return false;
        for (int i = x; i < x + 3; i++) {
            int tmp = 0;
            for (int j = y; j < y + 3; j++) {
                tmp += grid[i][j];
                if (grid[i][j] < 10 && grid[i][j] > 0) {
                    continue;
                } else {
                    return false;
                }
            }
            if (tmp != 15) return false;
        }
        int sum = 0;
        sum = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
        if (sum != 15) return false;

        sum = grid[x][y + 1] + grid[x + 1][y + 1] + grid[x + 2][y + 1];
        if (sum != 15) return false;

        sum = grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2];
        if (sum != 15) return false;

        sum = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
        if (sum != 15) return false;

        sum = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        if (sum != 15) return false;

        sum = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];
        if (sum != 15) return false;

        return true;

    }
}
