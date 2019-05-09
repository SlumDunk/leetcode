package com.github.leetcode.hard;

import com.github.leetcode.vo.Robot;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 3/18/19 13:23
 * @Description: Given a robot cleaner in a room modeled as a grid.
 * <p>
 * Each cell in the grid can be empty or blocked.
 * <p>
 * The robot cleaner with 4 given APIs can move forward, turn left or turn right. Each turn it made is 90 degrees.
 * <p>
 * When it tries to move into a blocked cell, its bumper sensor detects the obstacle and it stays on the current cell.
 * <p>
 * Design an algorithm to clean the entire room using only the 4 given APIs shown below.
 * <p>
 * interface Robot {
 * // returns true if next cell is open and robot moves into the cell.
 * // returns false if next cell is obstacle and robot stays on the current cell.
 * boolean move();
 * <p>
 * // Robot will stay on the same cell after calling turnLeft/turnRight.
 * // Each turn will be 90 degrees.
 * void turnLeft();
 * void turnRight();
 * <p>
 * // Clean the current cell.
 * void clean();
 * }
 * Example:
 * <p>
 * Input:
 * room = [
 * [1,1,1,1,1,0,1,1],
 * [1,1,1,1,1,0,1,1],
 * [1,0,1,1,1,1,1,1],
 * [0,0,0,1,0,0,0,0],
 * [1,1,1,1,1,1,1,1]
 * ],
 * row = 1,
 * col = 3
 * <p>
 * Explanation:
 * All grids in the room are marked by either 0 or 1.
 * 0 means the cell is blocked, while 1 means the cell is accessible.
 * The robot initially starts at the position of row=1, col=3.
 * From the top left corner, its position is one row below and three columns right.
 * Notes:
 * <p>
 * The input is only given to initialize the room and the robot's position internally. You must solve this problem "blindfolded". In other words, you must control the robot using only the mentioned 4 APIs, without knowing the room layout and the initial robot's position.
 * The robot's initial position will always be in an accessible cell.
 * The initial direction of the robot will be facing up.
 * All accessible cells are connected, which means the all cells marked as 1 will be accessible by the robot.
 * Assume all four edges of the grid are all surrounded by wall.
 */
public class Leetcode489 {
    final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            if (node.row == row && node.col == col) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int res = 17;
            res = res * 31 + row;
            res = res * 31 + col;
            return res;
        }
    }

    public void cleanRoom(Robot robot) {
        Set<Node> visited = new HashSet<>();
        find(robot, visited, 0, 0, 0);
    }

    private void find(Robot robot, Set<Node> visited, int curDirection, int row, int col) {
        Node node = new Node(row, col);
        visited.add(node);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int direction = (curDirection + i) % 4;
            int[] next = directions[direction];
            int nextRow = row + next[0];
            int nextCol = col + next[1];
            node = new Node(nextRow, nextCol);
            if (!visited.contains(node) && robot.move()) {
                find(robot, visited, direction, nextRow, nextCol);
                //backtrack, 回到原来的位置和方向
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }
    }
}
