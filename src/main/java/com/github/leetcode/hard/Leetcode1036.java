package com.github.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 16:49
 * @Description: In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.
 * <p>
 * We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.
 * <p>
 * Return true if and only if it is possible to reach the target square through a sequence of moves.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * Output: false
 * Explanation:
 * The target square is inaccessible starting from the source square, because we can't walk outside the grid.
 * Example 2:
 * <p>
 * Input: blocked = [], source = [0,0], target = [999999,999999]
 * Output: true
 * Explanation:
 * Because there are no blocked cells, it's possible to reach the target square.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 */
public class Leetcode1036 {
    Long M = 1000000L;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        //https://xingxingpark.com/Leetcode-1036-Escape-a-Large-Maze/
        /*
        只有开始位置和目标位置都不被阻碍物包围
        Since the len of blocked is no larger than 200,
        the closed area will be bounded by 200*200.
        */
        Set<Long> b = new HashSet<>(); //blocked square
        for (int[] n : blocked) b.add(n[0] * M + n[1]);

        //make sure both s and t will be surrounded by the block
        return check(b, source, target, source, new HashSet<>())
                && check(b, target, source, target, new HashSet<>());
    }

    /*
    @param b: 阻碍物位置s (x, y) -> x*M + y
    @param s: 开始位置
    @param t: 目标位置
    @param cur: 当前位置
    @param v:访问过的位置 (x, y) -> x*M + y
    */
    boolean check(Set<Long> b, int[] s, int[] t, int[] cur, Set<Long> v) {
        //we can stop the search when cur[i][j] is beyond the
        //largest closed area formed by blocked squares.
        if (Math.abs(cur[0] - s[0]) == 200
                || Math.abs(cur[1] - s[1]) == 200
                // 到达目的地
                || v.size() > 0 && cur[0] == t[0] && cur[1] == t[1])
            return true;

        v.add(cur[0] * M + cur[1]);

        for (int[] dir : dirs) {
            int x = cur[0] + dir[0];
            int y = cur[1] + dir[1];
            if (x < 0 || x == M || y < 0 || y == M
                    || v.contains(x * M + y) || b.contains(x * M + y))
                continue;
            if (check(b, s, t, new int[]{x, y}, v)) return true;
        }
        return false;
    }
}
