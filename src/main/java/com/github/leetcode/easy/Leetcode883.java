package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 15:52
 * @Description: On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * <p>
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 * <p>
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 * <p>
 * Return the total area of all three projections.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 5
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 17
 * Explanation:
 * Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
 * <p>
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 8
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 14
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 21
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 */
public class Leetcode883 {
    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 2}};
        Leetcode883 leetcode883 = new Leetcode883();
        System.out.println(leetcode883.projectionArea(grid));
    }

    public int projectionArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int xy = 0, yz = 0, xz = 0;
        int tmpyz = 0, tmpxz = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    xy++;
                    tmpxz = Math.max(grid[i][j], tmpxz);
                }
                if (grid[j][i] > 0) {
                    tmpyz = Math.max(grid[j][i], tmpyz);
                }
            }
            yz += tmpyz;
            tmpyz = 0;
            xz += tmpxz;
            tmpxz = 0;
        }
        return xy + yz + xz;
    }
}
