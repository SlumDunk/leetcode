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
        //存储值为0的元素位置
        Queue<Integer> queue = new LinkedList<Integer>();
        //先处理行边界
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O')
                queue.add(i);
            if (board[row - 1][i] == 'O')
                queue.add((row - 1) * col + i);
        }
        //处理列边界
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
            //上，右，下，左 顺时针
            if (x - 1 >= 0 && board[x - 1][y] == 'O')
                queue.add(num - col);
            if (y + 1 < col && board[x][y + 1] == 'O')
                queue.add(num + 1);
            if (x + 1 < row && board[x + 1][y] == 'O')
                queue.add(num + col);
            if (y - 1 >= 0 && board[x][y - 1] == 'O')
                queue.add(num - 1);
        }
        //跟边界上的0相通的都变成0，其他位置的0变成1
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

    public void solveDFS(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //处理列边界
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n - 1] == 'O')
                boundaryDFS(board, i, n - 1);
        }
        //处理行边界
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m - 1][j] == 'O')
                boundaryDFS(board, m - 1, j);
        }
        //将对应的元素做翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }

    /**
     * 深度遍历把边界上为0的元素变成*，且把与它四周为0的元素变成*
     *
     * @param board
     * @param i
     * @param j
     */
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i - 1][j] == 'O')
            boundaryDFS(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            boundaryDFS(board, i + 1, j);
        if (j > 1 && board[i][j - 1] == 'O')
            boundaryDFS(board, i, j - 1);
        if (j < board[i].length - 2 && board[i][j + 1] == 'O')
            boundaryDFS(board, i, j + 1);
    }
}
