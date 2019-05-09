package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/18/19 10:54
 * @Description: On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.
 * <p>
 * Now, a move consists of removing a stone that shares a column or row with another stone on the grid.
 * <p>
 * What is the largest possible number of moves we can make?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * Output: 5
 * Example 2:
 * <p>
 * Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * Output: 3
 * Example 3:
 * <p>
 * Input: stones = [[0,0]]
 * Output: 0
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
public class Leetcode947 {
    /**
     * 节点值为key, val为根祖先节点
     */
    Map<Integer, Integer> f = new HashMap<>();
    /**
     * 岛屿个数
     */
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; i++) {
            union(stones[i][0], ~stones[i][1]);
        }
        return stones.length - islands;
    }

    /**
     * @param x
     * @param y
     */
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }

    /**
     * 查找x的根祖先节点
     *
     * @param x
     * @return
     */
    private int find(int x) {
        if (f.putIfAbsent(x, x) == null) {
            islands++;
        }
        if (x != f.get(x)) {
            f.put(x, find(f.get(x)));
        }
        return f.get(x);
    }

    public int dfsRemoveStones(int[][] stones) {
        // Nodes (to avoid concurrent modification)
        List<Point> list = new ArrayList<>();
        // Visited Nodes
        Map<Point, Boolean> visited = new HashMap<>();
        // Adjacency Lists
        Map<Integer, List<Point>> xMap = new HashMap<>();
        Map<Integer, List<Point>> yMap = new HashMap<>();

        for (int[] stone : stones) {
            Point point = new Point(stone[0], stone[1]);
            list.add(point);
            visited.put(point, false);
            if (!xMap.containsKey(stone[0])) {
                xMap.put(stone[0], new ArrayList<>());
            }
            xMap.get(stone[0]).add(point);
            if (!yMap.containsKey(stone[1])) {
                yMap.put(stone[1], new ArrayList<>());
            }
            yMap.get(stone[1]).add(point);
        }

        int moves = 0;
        for (Point p : list) {
            if (!visited.get(p)) {
                moves += removeStonesHelper(p, visited, xMap, yMap) - 1;
            }
        }
        return moves;
    }

    private int removeStonesHelper(Point p, Map<Point, Boolean> visited, Map<Integer, List<Point>> xMap, Map<Integer, List<Point>> yMap) {
        int moves = 1;
        visited.put(p, true);

        for (Point p1 : xMap.get(p.x)) {
            if (!visited.get(p1)) {
                moves += removeStonesHelper(p1, visited, xMap, yMap);
            }
        }
        for (Point p2 : yMap.get(p.y)) {
            if (!visited.get(p2)) {
                moves += removeStonesHelper(p2, visited, xMap, yMap);
            }
        }

        return moves;
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

