package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 13:55
 * @Description: A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example:
 * <p>
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 * <p>
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * Follow up:
 * <p>
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class Leetcode305 {
    class UnionSet {
        public int size = 0;
        //存储当前节点和它的根节点
        private Map<Integer, Integer> pair = new HashMap<>();

        public void add(int a) {
            if (!pair.containsKey(a)) {
                pair.put(a, a);
                size++;
            }
        }

        /**
         * 合并两个岛屿
         *
         * @param a
         * @param b
         */
        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA == -1 || parentB == -1 || parentA == parentB) return;
            pair.put(parentA, parentB);
            size--;
        }

        /**
         * 查找岛屿的根祖先
         *
         * @param x
         * @return
         */
        private int find(int x) {
            Integer parent = pair.get(x);
            if (parent == null) return -1;
            if (parent == x) {
                return x;
            }
            pair.put(x, find(parent));
            return pair.get(x);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] dir = {0, 1, 0, -1, 0};
        UnionSet unionSet = new UnionSet();
        List<Integer> ans = new ArrayList<>();
        for (int[] pos :
                positions) {
            unionSet.add(pos[0] * n + pos[1]);
            for (int i = 0; i < 4; i++) {
                int x = pos[0] + dir[i];
                int y = pos[1] + dir[i + 1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                unionSet.union(pos[0] * n + pos[1], x * n + y);
            }
            ans.add(unionSet.size);
        }
        return ans;
    }
}
