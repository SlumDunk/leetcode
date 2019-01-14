package com.github.lintcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 1/13/19 23:21
 * @Description: Follow up for "Unique Paths II": http://lintcode.com/en/problem/unique-paths-ii/
 * <p>
 * Now each grid contains a value, so each path also has a value. Find the sum of all the unique values paths.
 * <p>
 * Example
 * For example,
 * <p>
 * [
 * [1,1,2],
 * [1,2,3],
 * [3,2,4]
 * ]
 * There are 2 unique value path:
 * [1,1,2,3,4] = 11
 * [1,1,2,2,4] = 10
 * <p>
 * return 21
 */
public class Lintcode679 {
    /*
    * @param : an array of arrays
    * @return: the sum of all unique weighted paths
    */
    public int uniqueWeightedPaths(int[][] grid) {
        // write your codes here

        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Set<Integer>> dp = new HashMap<Integer, Set<Integer>>();
        dp.put(0, new HashSet<Integer>());
        dp.get(0).add(grid[0][0]);

        for (int i = 1; i < m; i++) {
            int cur = i * n;
            int prev = (i - 1) * n;
            dp.put(cur, new HashSet<Integer>());
            for (Integer sum : dp.get(prev)) {
                dp.get(cur).add(sum + grid[i][0]);
            }
        }

        for (int i = 1; i < n; i++) {
            int cur = i;
            int prev = i - 1;
            dp.put(cur, new HashSet<Integer>());
            for (Integer sum : dp.get(prev)) {
                dp.get(cur).add(sum + grid[0][i]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int index = i * n + j;
                int up = index - n;
                int left = index - 1;
                dp.put(index, new HashSet<Integer>());
                for (Integer sum : dp.get(up)) {
                    dp.get(index).add(sum + grid[i][j]);
                }
                for (Integer sum : dp.get(left)) {
                    dp.get(index).add(sum + grid[i][j]);
                }
            }
        }

        int result = 0;
        int index = m * n - 1;
        for (Integer sum : dp.get(index)) {
            result += sum;
        }
        return result;
    }
}
