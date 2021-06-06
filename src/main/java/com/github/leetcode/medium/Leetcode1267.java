package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/10/21 08:45
 * @Description: You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 * <p>
 * Return the number of servers that communicate with any other server.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,0],[0,1]]
 * Output: 0
 * Explanation: No servers can communicate with others.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,0],[1,1]]
 * Output: 3
 * Explanation: All three servers can communicate with at least one other server.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * Output: 4
 * Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 */
public class Leetcode1267 {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int connectedNbr = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    int countNbr = helper(grid, visited, i, j, n, m);
                    if (countNbr > 1) {
                        connectedNbr += countNbr;
                    }
                }
            }
        }
        return connectedNbr;
    }

    private int helper(int[][] grid, boolean[][] visited, int x, int y, int n, int m) {
        visited[x][y] = true;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (grid[i][y] == 1 && visited[i][y] == false) {
                count += helper(grid, visited, i, y, n, m);
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[x][j] == 1 && visited[x][j] == false) {
                count += helper(grid, visited, x, j, n, m);
            }
        }
        return count;
    }
}
