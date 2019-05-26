package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 15:02
 * @Description: We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.
 * <p>
 * We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.
 * <p>
 * Return an array representing the number of bricks that will drop after each erasure in sequence.
 * <p>
 * Example 1:
 * Input:
 * grid = [[1,0,0,0],[1,1,1,0]]
 * hits = [[1,0]]
 * Output: [2]
 * Explanation:
 * If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
 * Example 2:
 * Input:
 * grid = [[1,0,0,0],[1,1,0,0]]
 * hits = [[1,1],[1,0]]
 * Output: [0,0]
 * Explanation:
 * When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of rows and columns in the grid will be in the range [1, 200].
 * The number of erasures will not exceed the area of the grid.
 * It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.
 * An erasure may refer to a location with no brick - if it does, no bricks drop.
 */
public class Leetcode803 {
    class UnionFind {
        int[] id, size;

        public UnionFind(int len) {
            this.id = new int[len];
            this.size = new int[len];
            for (int i = 0; i < len; i++) {
                id[i] = i;
                Arrays.fill(this.size, 1);
            }

        }

        /**
         * 找到最根部的祖先
         *
         * @param i
         * @return
         */
        int find(int i) {
            while (id[i] != i) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        /**
         * 合并两个节点
         *
         * @param i
         * @param j
         */
        void union(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);
            if (p1 != p2) {
                id[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        for (int[] h :
                hits) {
            if (grid[h[0]][h[1]] == 1) {//做上标记
                grid[h[0]][h[1]] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionAll(i, j, grid, uf);
                }
            }
        }

        int[] res = new int[hits.length];
        int count = uf.size[uf.find(0)];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 2) {
                unionAll(x, y, grid, uf);
                grid[x][y] = 1;//重置标记
            }
            int newCount = uf.size[uf.find(0)];
            res[i] = newCount > count ? newCount - count - 1 : 0;
            count = newCount;
        }
        return res;

    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 朝四个方向合并
     * @param i
     * @param j
     * @param grid
     * @param uf
     */
    private void unionAll(int i, int j, int[][] grid, UnionFind uf) {
        int m = grid.length, n = grid[0].length;
        for (int[] dir :
                dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x == m || y < 0 || y == n || grid[x][y] != 1) continue;
            uf.union(i * n + j + 1, x * n + y + 1);
        }
        //如果是顶部，绑定到点(0,0)
        if (i == 0) uf.union(j + 1, 0);

    }
}
