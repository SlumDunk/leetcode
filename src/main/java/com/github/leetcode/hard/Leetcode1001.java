package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 5/26/19 19:10
 * @Description: On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.
 * <p>
 * Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is on.  Each lamp that is on illuminates every square on its x-axis, y-axis, and both diagonals (similar to a Queen in chess).
 * <p>
 * For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is illuminated, else 0.
 * <p>
 * After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell (x, y) or are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)
 * <p>
 * Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query queries[i].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * Output: [1,0]
 * Explanation:
 * Before performing the first query we have both lamps [0,0] and [4,4] on.
 * The grid representing which cells are lit looks like this, where [0,0] is the top left corner, and [4,4] is the bottom right corner:
 * 1 1 1 1 1
 * 1 1 0 0 1
 * 1 0 1 0 1
 * 1 0 0 1 1
 * 1 1 1 1 1
 * Then the query at [1, 1] returns 1 because the cell is lit.  After this query, the lamp at [0, 0] turns off, and the grid now looks like this:
 * 1 0 0 0 1
 * 0 1 0 0 1
 * 0 0 1 0 1
 * 0 0 0 1 1
 * 1 1 1 1 1
 * Before performing the second query we have only the lamp [4,4] on.  Now the query at [1,0] returns 0, because the cell is no longer lit.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * 0 <= lamps.length <= 20000
 * 0 <= queries.length <= 20000
 * lamps[i].length == queries[i].length == 2
 */
public class Leetcode1001 {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 0}};

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        //行号为key，灯数为value
        Map<Integer, Integer> m1 = new HashMap<>();
        //列号为key,灯数为value
        Map<Integer, Integer> m2 = new HashMap<>();
        //x-y为key,灯数为value 副对角线
        Map<Integer, Integer> m3 = new HashMap<>();
        //x+y为key,灯数为value 主对角线
        Map<Integer, Integer> m4 = new HashMap<>();
        //是否存在开着的灯
        Map<Integer, Boolean> m5 = new HashMap<>();

        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0];
            int y = lamps[i][1];
            m1.put(x, m1.getOrDefault(x, 0) + 1);
            m2.put(y, m2.getOrDefault(y, 0) + 1);
            m3.put(x - y, m3.getOrDefault(x - y, 0) + 1);
            m4.put(x + y, m4.getOrDefault(x + y, 0) + 1);
            m5.put(N * x + y, true);
        }
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            ans[i] = (m1.getOrDefault(x, 0) > 0 || m2.getOrDefault(y, 0) > 0 || m3.getOrDefault(
                    x - y, 0) > 0 || m4.getOrDefault(x + y, 0) > 0) ? 1 : 0;
            for (int j = 0; j < dirs.length; j++) {
                int x1 = x + dirs[j][0];
                int y1 = y + dirs[j][1];
                if (m5.containsKey(N * x1 + y1) && m5.get(N * x1 + y1)) {
                    m1.put(x1, m1.getOrDefault(x1, 1) - 1);
                    m2.put(y1, m2.getOrDefault(y1, 1) - 1);
                    m3.put(x1 - y1, m3.getOrDefault(x1 - y1, 1) - 1);
                    m4.put(x1 + y1, m4.getOrDefault(x1 + y1, 1) - 1);
                    m5.put(N * x1 + y1, false);
                }
            }
        }
        return ans;
    }
}
