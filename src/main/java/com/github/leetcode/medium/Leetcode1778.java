package com.github.leetcode.medium;

import java.util.*;

/**
 * This is an interactive problem.
 * <p>
 * There is a robot in a hidden grid, and you are trying to get it from its starting cell to the target cell in this grid. The grid is of size m x n, and each cell in the grid is either empty or blocked. It is guaranteed that the starting cell and the target cell are different, and neither of them is blocked.
 * <p>
 * You want to find the minimum distance to the target cell. However, you do not know the grid's dimensions, the starting cell, nor the target cell. You are only allowed to ask queries to the GridMaster object.
 * <p>
 * Thr GridMaster class has the following functions:
 * <p>
 * boolean canMove(char direction) Returns true if the robot can move in that direction. Otherwise, it returns false.
 * void move(char direction) Moves the robot in that direction. If this move would move the robot to a blocked cell or off the grid, the move will be ignored, and the robot will remain in the same position.
 * boolean isTarget() Returns true if the robot is currently on the target cell. Otherwise, it returns false.
 * Note that direction in the above functions should be a character from {'U','D','L','R'}, representing the directions up, down, left, and right, respectively.
 * <p>
 * Return the minimum distance between the robot's initial starting cell and the target cell. If there is no valid path between the cells, return -1.
 * <p>
 * Custom testing:
 * <p>
 * The test input is read as a 2D matrix grid of size m x n where:
 * <p>
 * grid[i][j] == -1 indicates that the robot is in cell (i, j) (the starting cell).
 * grid[i][j] == 0 indicates that the cell (i, j) is blocked.
 * grid[i][j] == 1 indicates that the cell (i, j) is empty.
 * grid[i][j] == 2 indicates that the cell (i, j) is the target cell.
 * There is exactly one -1 and 2 in grid. Remember that you will not have this information in your code.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[1,2],[-1,0]]
 * Output: 2
 * Explanation: One possible interaction is described below:
 * The robot is initially standing on cell (1, 0), denoted by the -1.
 * - master.canMove('U') returns true.
 * - master.canMove('D') returns false.
 * - master.canMove('L') returns false.
 * - master.canMove('R') returns false.
 * - master.move('U') moves the robot to the cell (0, 0).
 * - master.isTarget() returns false.
 * - master.canMove('U') returns false.
 * - master.canMove('D') returns true.
 * - master.canMove('L') returns false.
 * - master.canMove('R') returns true.
 * - master.move('R') moves the robot to the cell (0, 1).
 * - master.isTarget() returns true.
 * We now know that the target is the cell (0, 1), and the shortest path to the target cell is 2.
 * Example 2:
 * <p>
 * Input: grid = [[0,0,-1],[1,1,1],[2,0,0]]
 * Output: 4
 * Explanation: The minimum distance between the robot and the target cell is 4.
 * Example 3:
 * <p>
 * Input: grid = [[-1,0],[0,2]]
 * Output: -1
 * Explanation: There is no path from the robot to the target cell.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n, m <= 500
 * m == grid.length
 * n == grid[i].length
 * grid[i][j] is either -1, 0, 1, or 2.
 * There is exactly one -1 in grid.
 * There is exactly one 2 in grid.
 */
public class Leetcode1778 {

    interface GridMaster {
        boolean canMove(char direction);

        void move(char direction);

        boolean isTarget();
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    final static char[] DIR = {'U', 'R', 'D', 'L'};
    final static int[][] STEPS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair> set = new HashSet<>();
    private GridMaster master;
    Pair target = null;

    public int findShortestPath(GridMaster master) {
        this.master = master;
        dfs(0, 0);
        if (target == null) return -1;

        return bfs();
    }


    private int bfs() {
        Queue<int[]> pq=new LinkedList<>();
        // 坐标系下 (0,0) 就是出发点
        pq.offer(new int[]{0, 0});
        int count = 0;
        while (!pq.isEmpty()) {
            int size=pq.size();
            while(size-->0) {
                int[] cur = pq.poll();
                if (cur[0] == target.x && cur[1] == target.y)
                    return count;
                for (int[] step :
                        STEPS) {
                    int x1 = cur[0] + step[0];
                    int y1 = cur[1] + step[1];
                    if (!set.contains(new Pair(x1, y1))) continue;
                    set.remove(new Pair(x1, y1));
                    pq.offer(new int[]{x1, y1});
                }
            }
            count++;
        }
        return -1;
    }

    /**
     * 移动每一个位置需要消耗的成本 相对坐标系, 出发点的坐标 设为 (0,0), 其他点和他是相对坐标系
     *
     * @param x
     * @param y
     */
    private void dfs(int x, int y) {
        if (master.isTarget()) {
            target = new Pair(x, y);
        }

        for (int i = 0; i < 4; i++) {
            int x1 = x + STEPS[i][0];
            int y1 = y + STEPS[i][1];
            if (!set.contains(new Pair(x1, y1)) && master.canMove(DIR[i])) {
                master.move(DIR[i]);
                set.add(new Pair(x1, y1));
                dfs(x1, y1);
                master.move(DIR[(i + 2) % 4]);
            }
        }
    }
}
