package com.github.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 3/23/19 10:24
 * @Description: On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * <p>
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * <p>
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * <p>
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return -1.
 * <p>
 * Examples:
 * <p>
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 * Note:
 * <p>
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */
public class Leetcode773 {
    public int slidingPuzzle(int[][] board) {
        //找最短路径
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();
        //每个0可以出现的位置的可交换位置
        int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return res;
                }
                int zeroIndex = cur.indexOf('0');
                for (int dir :
                        dirs[zeroIndex]) {
                    String next = swap(cur, zeroIndex, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    /**
     * 交换字符串中两个字符
     *
     * @param str
     * @param i
     * @param j
     * @return
     */
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
