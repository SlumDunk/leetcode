package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 15:20
 * @Description: Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
 * <p>
 * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
 * <p>
 * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * Output: 3
 * Explanation:
 * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
 * Example 2:
 * <p>
 * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * Output: 0
 * Explanation:
 * All 1s are either on the boundary or can reach the boundary.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * All rows have the same size.
 */
public class Leetcode1020 {
    public int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public boolean nexttoedge = false;

    public int numEnclaves(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int count = DFS(A, i, j);
                if (!nexttoedge) sum += count;
                //重新置位
                nexttoedge = false;

            }
        }
        return sum;

    }

    /**
     * @param A
     * @param r
     * @param c
     * @return
     */
    public int DFS(int[][] A, int r, int c) {
        if (A[r][c] != 1) return 0;
        int count = 1;
        //设置了已访问标志
        A[r][c] = 2;
        for (int[] dir : directions) {
            int row = r + dir[0];
            int col = c + dir[1];
            //有一个接触了边
            if (row < 0 || row >= A.length || col < 0 || col >= A[0].length) {
                nexttoedge = true;
                continue;
            }

            count += DFS(A, row, col);
        }

        return count;
    }
}
