package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/27/19 08:30
 * @Description: On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
 * <p>
 * Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.
 * <p>
 * Now, we walk in a clockwise spiral shape to visit every position in this grid.
 * <p>
 * Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.)
 * <p>
 * Eventually, we reach all R * C spaces of the grid.
 * <p>
 * Return a list of coordinates representing the positions of the grid in the order they were visited.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: R = 1, C = 4, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: R = 5, C = 6, r0 = 1, c0 = 4
 * Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */
public class Leetcode885 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        //记录每一步的位置
        int[][] steps = new int[R * C][2];
        //记录步长
        int stepSize = 0;

        steps[0][0] = r0;
        steps[0][1] = c0;

        //结果数组中的索引
        int stepCount = 1;

        while (stepCount < R * C) {
            //向右，向下 增加一步
            stepSize++;
            // go right
            for (int i = 0; i < stepSize; i++) {
                stepCount = visit(steps, R, C, r0, ++c0, stepCount);
            }

            // go down
            for (int i = 0; i < stepSize; i++) {
                stepCount = visit(steps, R, C, ++r0, c0, stepCount);
            }

            //向左，向上增加一步
            stepSize++;
            // go left
            for (int i = 0; i < stepSize; i++) {
                stepCount = visit(steps, R, C, r0, --c0, stepCount);
            }

            // go up
            for (int i = 0; i < stepSize; i++) {
                stepCount = visit(steps, R, C, --r0, c0, stepCount);
            }
        }

        return steps;
    }

    /**
     * 判断目标位置是否越界
     *
     * @param rows
     * @param cols
     * @param i
     * @param j
     * @return
     */
    public boolean withinBounds(int rows, int cols, int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    /**
     * @param steps
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @param stepCount
     * @return
     */
    public int visit(int[][] steps, int R, int C, int r0, int c0, int stepCount) {
        if (withinBounds(R, C, r0, c0)) {
            steps[stepCount][0] = r0;
            steps[stepCount][1] = c0;
            stepCount++;
        }
        return stepCount;
    }
}
