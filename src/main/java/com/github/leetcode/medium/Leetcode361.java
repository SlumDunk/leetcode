package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/2/19 19:47
 * @Description: Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 * <p>
 * Example:
 * <p>
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * <p>
 * Placing a bomb at (1,1) kills 3 enemies.
 */
public class Leetcode361 {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        //从上到下扫
        int[][] up = new int[m][n];
        //从下往上扫
        int[][] down = new int[m][n];
        //从左到右扫
        int[][] left = new int[m][n];
        //从右往左扫
        int[][] right = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                up[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1;
                    }
                    if (i - 1 >= 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                down[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1;
                    }
                    if (i + 1 < m) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                left[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        left[i][j] = 1;
                    }
                    if (j - 1 >= 0) {
                        left[i][j] += left[i][j - 1];
                    }
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j++) {
                right[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        right[i][j] = 1;
                    }

                    if (j + 1 < n) {
                        right[i][j] += right[i][j + 1];
                    }
                }
            }
        }
        int temp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    temp = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    result = Math.max(temp, result);
                }
            }
        }
        return result;
    }


    public int maxKilledEnemies__(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        // 0 E 0 0
        // E 0 W E
        // 0 E 0 0
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        //首行
        for (int i = 0; i < n; i++) {
            switch (grid[0][i]) {
                case '0':
                    up[0][i] = 0;
                    break;
                case 'E':
                    up[0][i] = 1;
                    break;
                case 'W':
                    up[0][i] = 0;
                    break;
                default:
                    break;
            }
        }

        //首列
        for (int i = 0; i < m; i++) {
            switch (grid[i][0]) {
                case '0':
                    left[i][0] = 0;
                    break;
                case 'E':
                    left[i][0] = 1;
                    break;
                case 'W':
                    left[i][0] = 0;
                    break;
                default:
                    break;
            }
        }

        //末行
        for (int i = 0; i < n; i++) {
            switch (grid[m - 1][i]) {
                case '0':
                    down[m - 1][i] = 0;
                    break;
                case 'E':
                    down[m - 1][i] = 1;
                    break;
                case 'W':
                    down[m - 1][i] = 0;
                    break;
                default:
                    break;
            }
        }

        //末列
        for (int i = 0; i < m; i++) {
            switch (grid[i][n - 1]) {
                case '0':
                    right[i][n - 1] = 0;
                    break;
                case 'E':
                    right[i][n - 1] = 1;
                    break;
                case 'W':
                    right[i][n - 1] = 0;
                    break;
                default:
                    break;
            }
        }

        //向上方向 从上往下计算
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (grid[i][j]) {
                    case '0':
                        up[i][j] = up[i - 1][j];
                        break;
                    case 'E':
                        up[i][j] = 1 + up[i - 1][j];
                        break;
                    case 'W':
                        up[i][j] = 0;
                        break;
                    default:
                        break;
                }
            }
        }


        //向下方向 从下往上计算
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                switch (grid[i][j]) {
                    case '0':
                        down[i][j] = down[i + 1][j];
                        break;
                    case 'E':
                        down[i][j] = 1 + down[i + 1][j];
                        break;
                    case 'W':
                        down[i][j] = 0;
                        break;
                    default:
                        break;
                }
            }
        }

        //向左方向 从左往右计算
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                switch (grid[i][j]) {
                    case '0':
                        left[i][j] = left[i][j - 1];
                        break;
                    case 'E':
                        left[i][j] = 1 + left[i][j - 1];
                        break;
                    case 'W':
                        left[i][j] = 0;
                        break;
                    default:
                        break;
                }
            }
        }

        //向右方向 从右向左计算
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                switch (grid[i][j]) {
                    case '0':
                        right[i][j] = right[i][j + 1];
                        break;
                    case 'E':
                        right[i][j] = 1 + right[i][j + 1];
                        break;
                    case 'W':
                        right[i][j] = 0;
                        break;
                    default:
                        break;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                switch (grid[i][j]) {
                    case '0':
                        max = Math.max(max, left[i][j] + right[i][j] + up[i][j] + down[i][j]);
                        break;
                    case 'E':
                        break;
                    case 'W':
                        break;
                    default:
                        break;
                }
            }
        }
        return max;

    }
}
