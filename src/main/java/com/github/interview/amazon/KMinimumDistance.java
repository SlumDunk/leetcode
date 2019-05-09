package com.github.interview.amazon;

/**
 * @Author: zerongliu
 * @Date: 4/10/19 17:39
 * @Description:
 */
public class KMinimumDistance {

    /**
     * up, right, down, left
     */
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int removeObstacle(int numRows, int numColumns, int[][] lot) {
        if (lot == null || lot.length == 0 || lot[0].length == 0) {
            return 0;
        } else {
            return dfs(0, 0, lot, 0, numRows, numColumns);
        }
    }

    /**
     * 深度遍历
     *
     * @param row
     * @param col
     * @param lot
     * @param distance
     * @param numRows
     * @param numColumns
     * @return
     */
    private int dfs(int row, int col, int[][] lot, int distance, int numRows, int numColumns) {
        if (row < 0 || row > numRows || col < 0 || numRows > numColumns || lot[row][col] == 0) {
            return Integer.MAX_VALUE;
        }
        if (lot[row][col] == 9) {
            return distance;
        } else {
            int mimumDistance = Integer.MAX_VALUE;
            for (int i = 0; i < directions.length; i++) {
                for (int j = 0; j < directions[0].length; j++) {
                    mimumDistance = Math.min(mimumDistance, dfs(row + i, col + j, lot, distance + 1, numRows, numColumns));
                }
            }
            return mimumDistance;
        }
    }
}
