package com.github.leetcode.hard;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Storekeeper is a game in which the player pushes boxes around in a warehouse trying to get them to target locations.
 * <p>
 * The game is represented by a grid of size m x n, where each element is a wall, floor, or a box.
 * <p>
 * Your task is move the box 'B' to the target position 'T' under the following rules:
 * <p>
 * Player is represented by character 'S' and can move up, down, left, right in the grid if it is a floor (empy cell).
 * Floor is represented by character '.' that means free cell to walk.
 * Wall is represented by character '#' that means obstacle  (impossible to walk there).
 * There is only one box 'B' and one target cell 'T' in the grid.
 * The box can be moved to an adjacent free cell by standing next to the box and then moving in the direction of the box. This is a push.
 * The player cannot walk through the box.
 * Return the minimum number of pushes to move the box to the target. If there is no way to reach the target, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#",".","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * Output: 3
 * Explanation: We return only the number of times the box is pushed.
 * Example 2:
 * <p>
 * Input: grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#","#","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * Output: -1
 * Example 3:
 * <p>
 * Input: grid = [["#","#","#","#","#","#"],
 * ["#","T",".",".","#","#"],
 * ["#",".","#","B",".","#"],
 * ["#",".",".",".",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * Output: 5
 * Explanation:  push the box down, left, left, up and up.
 * Example 4:
 * <p>
 * Input: grid = [["#","#","#","#","#","#","#"],
 * ["#","S","#",".","B","T","#"],
 * ["#","#","#","#","#","#","#"]]
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 20
 * 1 <= n <= 20
 * grid contains only characters '.', '#',  'S' , 'T', or 'B'.
 * There is only one character 'S', 'B' and 'T' in the grid.
 */
public class Leetcode1263 {
    class State {
        int pRow;
        int pCol;
        int bRow;
        int bCol;

        State() {
        }

        State(int pRow, int pCol, int bRow, int bCol) {
            this.pRow = pRow;
            this.pCol = pCol;
            this.bRow = bRow;
            this.bCol = bCol;
        }
    }

    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minPushBox(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        State initState = new State();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 'S') {
                    initState.pRow = row;
                    initState.pCol = col;
                } else if (grid[row][col] == 'B') {
                    initState.bRow = row;
                    initState.bCol = col;
                }
            }
        }

        boolean[][][] visited = new boolean[rows][cols][4];
        Deque<State> queue = new ArrayDeque<>();
        queue.add(initState);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State cur = queue.poll();
                for (int dir = 0; dir < dirs.length; dir++) {
                    int adjBRow = cur.bRow + dirs[dir][0];
                    int adjBCol = cur.bCol + dirs[dir][1];

                    int adjPRow = cur.bRow - dirs[dir][0];
                    int adjPCol = cur.bCol - dirs[dir][1];
                    if (!isValid(adjBRow, adjBCol, adjPRow, adjPCol, grid) || visited[adjBRow][adjBCol][dir]
                            || !playerCanReachBox(grid, cur.pRow, cur.pCol, adjPRow, adjPCol, cur.bRow, cur.bCol)) {
                        continue;
                    }
                    if (grid[adjBRow][adjBCol] == 'T') {
                        return steps;
                    }
                    visited[adjBRow][adjBCol][dir] = true;
                    queue.add(new State(cur.bRow, cur.bCol, adjBRow, adjBCol));
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean playerCanReachBox(char[][] grid, int curPRow, int curPCol, int targetPRow, int targetPCol, int bRow, int bCol) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (curPRow == targetPRow && curPCol == targetPCol) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(curPRow * cols + curPCol);
        boolean[][] visited = new boolean[rows][cols];
        visited[curPRow][curPCol] = true;
        visited[bRow][bCol] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int row = index / cols;
            int col = index % cols;
            for (int[] dir :
                    dirs) {
                int adjRow = row + dir[0];
                int adjCol = col + dir[1];
                if (adjRow < 0 || adjRow >= rows || adjCol < 0 || adjCol >= cols ||
                        visited[adjRow][adjCol] || grid[adjRow][adjCol] == '#') {
                    continue;
                }
                if (adjRow == targetPRow && adjCol == targetPCol) {
                    return true;
                }
                queue.add(adjRow * cols + adjCol);
                visited[adjRow][adjCol] = true;
            }
        }

        return false;
    }

    private boolean isValid(int adjBRow, int adjBCol, int adjPRow, int adjPCol, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return adjBRow >= 0 && adjBRow < m && adjBCol >= 0 && adjBCol < n && adjPRow >= 0 && adjPRow < m && adjPCol >= 0
                && adjPCol < n && grid[adjBRow][adjBCol] != '#' && grid[adjPRow][adjPCol] != '#';
    }
}
