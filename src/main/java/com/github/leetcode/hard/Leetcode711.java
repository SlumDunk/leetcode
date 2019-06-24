package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 15:25
 * @Description: Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if they have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).
 * <p>
 * Example 1:
 * 11000
 * 10000
 * 00001
 * 00011
 * Given the above grid map, return 1.
 * <p>
 * Notice that:
 * 11
 * 1
 * and
 * 1
 * 11
 * are considered same island shapes. Because if we make a 180 degrees clockwise rotation on the first island, then two islands will have the same shapes.
 * Example 2:
 * 11100
 * 10001
 * 01001
 * 01110
 * Given the above grid map, return 2.
 * <p>
 * Here are the two distinct islands:
 * 111
 * 1
 * and
 * 1
 * 1
 * <p>
 * Notice that:
 * 111
 * 1
 * and
 * 1
 * 111
 * are considered same island shapes. Because if we flip the first array in the up/down direction, then they have the same shapes.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
public class Leetcode711 {
    /**
     * 数据矩阵
     */
    int[][] grid;
    /**
     * 记录已访问位置
     */
    boolean[][] seen;
    /**
     * 记录区域的形状
     */
    ArrayList<Integer> shape;

    /**
     * DFS拓展区域的形状
     * @param r
     * @param c
     */
    public void explore(int r, int c) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length &&
                grid[r][c] == 1 && !seen[r][c]) {
            seen[r][c] = true;
            shape.add(r * grid[0].length + c);
            explore(r + 1, c);
            explore(r - 1, c);
            explore(r, c + 1);
            explore(r, c - 1);
        }
    }

    /**
     * 根据区域中各个点的位置信息返回区域的唯一形状字符串
     * @param shape
     * @return
     */
    public String canonical(ArrayList<Integer> shape) {
        String ans = "";
        int lift = grid.length + grid[0].length;
        int[] out = new int[shape.size()];
        int[] xs = new int[shape.size()];
        int[] ys = new int[shape.size()];

        //8个方向 x y, x -y, -x y, -x -y, y x, y -x, -y x, -y -x
        for (int c = 0; c < 8; ++c) {
            int t = 0;
            for (int z : shape) {
                int x = z / grid[0].length;
                int y = z % grid[0].length;
                xs[t] = c <= 1 ? x : c <= 3 ? -x : c <= 5 ? y : -y;
                ys[t++] = c <= 3 ? (c % 2 == 0 ? y : -y) : (c % 2 == 0 ? x : -x);
            }

            int mx = xs[0], my = ys[0];
            //寻找最小的x坐标和y坐标
            for (int x : xs) mx = Math.min(mx, x);
            for (int y : ys) my = Math.min(my, y);

            for (int j = 0; j < shape.size(); ++j) {
                out[j] = (xs[j] - mx) * lift + (ys[j] - my);
            }
            //排序
            Arrays.sort(out);
            String candidate = Arrays.toString(out);
            if (ans.compareTo(candidate) < 0) ans = candidate;
        }
        return ans;
    }


    /**
     * Time Complexity: O(R*C \log{(R*C)})O(R∗Clog(R∗C)), where RR is the number of rows in the given grid, and CC is the number of columns. We visit every square once, and each square belongs to at most one shape. The log factor comes from sorting the shapes.
     * <p>
     * Space complexity: O(R*C)O(R∗C), the space used to keep track of the shapes.
     *
     * @param grid
     * @return
     */
    public int numDistinctIslands2(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        Set shapes = new HashSet<String>();

        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                shape = new ArrayList();
                explore(r, c);
                if (!shape.isEmpty()) {
                    shapes.add(canonical(shape));
                }
            }
        }

        return shapes.size();
    }
}
