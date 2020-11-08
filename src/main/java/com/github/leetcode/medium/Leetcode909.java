package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 3/23/19 15:52
 * @Description: On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating directs each row.  For example, for a 6 x 6 board, the numbers are written as follows:
 * <p>
 * <p>
 * You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:
 * <p>
 * You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
 * (This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations.)
 * If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
 * A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].
 * <p>
 * Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)
 * <p>
 * Return the least number of moves required to reach square N*N.  If it is not possible, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: [
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,35,-1,-1,13,-1],
 * [-1,-1,-1,-1,-1,-1],
 * [-1,15,-1,-1,-1,-1]]
 * Output: 4
 * Explanation:
 * At the beginning, you start at square 1 [at row 5, column 0].
 * You decide to move to square 2, and must take the ladder to square 15.
 * You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
 * You then decide to move to square 14, and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
 * Note:
 * <p>
 * 2 <= board.length = board[0].length <= 20
 * board[i][j] is between 1 and N*N or is equal to -1.
 * The board square with number 1 has no snake or ladder.
 * The board square with number N*N has no snake or ladder.
 */
public class Leetcode909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        for (int move = 0; !queue.isEmpty(); move++) {
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                if (visited[num]) continue;
                visited[num] = true;
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) queue.offer(next);
                }
            }
        }
        return -1;

    }

    /**
     * 根据当前位置有没有ladder判断下个有效位置
     *
     * @param board
     * @param next
     * @return
     */
    private int getBoardValue(int[][] board, int next) {
        int n = board.length;
        //倒数第几行
        int r = (next - 1) / n;
        //数组中第几行
        int x = n - 1 - r;

        int len = next - r * n;

        //倒数行 为偶，从左到右扫，为奇，从右到左扫
        int y = r % 2 == 0 ? len - 1 : n - len;
        return board[x][y];
    }


    /**
     * O(n)
     *
     * @param board
     * @return
     */
    public int snakesAndLadders_(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int move = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int num = queue.poll();
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue_(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
                size--;
            }
            move++;
        }
        return -1;
    }

    /**
     * 根据当前位置有没有ladder判断下个有效位置
     *
     * @param board
     * @param next
     * @return
     */
    private int getBoardValue_(int[][] board, int next) {
        int n = board.length;
        //倒数第几行
        int r = (next - 1) / n;
        //数组中第几行
        int x = n - 1 - r;

        int len = next - r * n;

        //倒数行 为偶，从左到右扫，为奇，从右到左扫
        int y = r % 2 == 0 ? len - 1 : n - len;
        return board[x][y];
    }
}
