package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 20:39
 * @Description: Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class Leetcode130 {
    public void solve(char[][] board) {
        int row = board.length;
        if (row < 2)
            return;
        int col = board[0].length;
        if (col < 2)
            return;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O')
                queue.add(i);
            if (board[row - 1][i] == 'O')
                queue.add((row - 1) * col + i);
        }
        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == 'O')
                queue.add(i * col + col - 1);
            if (board[i][0] == 'O')
                queue.add(i * col);
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int x = num / col, y = num % col;
            if (board[x][y] != 'O')
                continue;
            board[x][y] = 'o';
            if (x - 1 >= 0 && board[x - 1][y] == 'O')
                queue.add(num - col);
            if (x + 1 < row && board[x + 1][y] == 'O')
                queue.add(num + col);
            if (y - 1 >= 0 && board[x][y - 1] == 'O')
                queue.add(num - 1);
            if (y + 1 < col && board[x][y + 1] == 'O')
                queue.add(num + 1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'o')
                    board[i][j] = 'O';
            }
        }
        return;
    }
}
