package com.github.interview.wepay;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 10/20/19 15:04
 * @Description:
 */
public class Wepay2 {

    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int slidingPuzzle(int[][] board) {
        //找最短路径
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }
        int n = board.length;
        int m = board[0].length;

        int[][] target = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                target[i][j] = (i) * m + j;
            }
        }

        String targetStr = matrix2String(target);
        System.out.println(targetStr);

        int[][] start = new int[n][m];
        for (int i = 0; i < start.length; i++) {
            System.arraycopy(board[i], 0, start[i], 0, board[i].length);
        }

        Position zeroIdx = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    zeroIdx = new Position(i, j);
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, zeroIdx));
        visited.add(matrix2String(start));

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                if (targetStr.equals(matrix2String(cur.matrix))) {
                    return res;
                }
                zeroIdx = cur.zeroIndex;
                for (int[] dir :
                        dirs) {
                    int nx = zeroIdx.row + dir[0];
                    int ny = zeroIdx.col + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        Position nxZeroIdx = new Position(nx, ny);
                        int[][] next = swap(cur.matrix, zeroIdx, nxZeroIdx);
                        if (visited.contains(matrix2String(next))) {
                            continue;
                        }
                        visited.add(matrix2String(next));
                        queue.add(new Pair(next, nxZeroIdx));
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private String matrix2String(int[][] matrix) {
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                buffer.append(matrix[i][j]);
            }
        }
        return buffer.toString();
    }

    class Pair {
        int[][] matrix;
        Position zeroIndex;

        public Pair(int[][] matrix, Position zeroIndex) {
            this.matrix = matrix;
            this.zeroIndex = zeroIndex;
        }
    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * @param current
     * @param currentZeroIdx
     * @param nxZeroIdx
     * @return
     */
    private int[][] swap(int[][] current, Position currentZeroIdx, Position nxZeroIdx) {
        int[][] copy = new int[current.length][current[0].length];

        for (int i = 0; i < copy.length; i++) {
            System.arraycopy(current[i], 0, copy[i], 0, current[i].length);
        }

        int temp = copy[currentZeroIdx.row][currentZeroIdx.col];
        copy[currentZeroIdx.row][currentZeroIdx.col] = copy[nxZeroIdx.row][nxZeroIdx.col];
        copy[nxZeroIdx.row][nxZeroIdx.col] = temp;
        return copy;
    }

    public static void main(String[] args) {
        Wepay2 wepay2 = new Wepay2();
        int[][] board = new int[][]{{1,2,3}, {4,0,5}};
        System.out.println(wepay2.slidingPuzzle(board));

    }
}
