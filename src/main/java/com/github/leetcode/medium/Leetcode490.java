package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 14:15
 * @Description: There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * <p>
 * Output: true
 * <p>
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * <p>
 * Example 2:
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * <p>
 * Output: false
 * <p>
 * Explanation: There is no way for the ball to stop at the destination.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and idx of the maze won't exceed 100.
 */
public class Leetcode490 {
    int[][] steps = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        return dfs(maze, start, destination, visited, rows, cols);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited, int rows, int cols) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        for (int[] step : steps
                ) {
            int dx = start[0];
            int dy = start[1];
            while (dx + step[0] >= 0 && dx + step[0] < rows && dy + step[1] >= 0 && dy + step[1] < cols && maze[dx + step[0]][dy + step[1]] != 1) {
                dx += step[0];
                dy += step[1];
            }
            if (dfs(maze, new int[]{dx, dy}, destination, visited, rows, cols)) {
                return true;
            }
        }
        return false;
    }
}
