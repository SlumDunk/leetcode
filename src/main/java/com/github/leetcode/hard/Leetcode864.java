package com.github.leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 21:49
 * @Description: We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 * <p>
 * We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 * <p>
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 * <p>
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Example 2:
 * <p>
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 */
public class Leetcode864 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int si = -1, sj = -1, k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    si = i;
                    sj = j;
                }
                if (isKey(c)) k++;
            }
        }

        Node start = new Node(si, sj, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(si + " " + sj + " " + 0);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.key == (1 << k) - 1) return level;
                for (int[] d : dirs) {
                    int x = cur.i + d[0];
                    int y = cur.j + d[1];
                    int key = cur.key;
                    if (!isValid(grid, x, y, m, n)) continue;
                    char c = grid[x].charAt(y);
                    //是钥匙添加到状态位
                    if (isKey(c)) key |= (1 << (c - 'a'));
                    //没有持有锁的钥匙，跳过
                    if (isLock(c) && (key >> (c - 'A') & 1) == 0) continue;
                    //未访问过，添加到队列
                    if (visited.add(x + " " + y + " " + key)) queue.offer(new Node(x, y, key));
                }
            }
            level++;
        }
        return -1;
    }

    /**
     * 判断是不是锁
     *
     * @param c
     * @return
     */
    private boolean isLock(char c) {
        return c >= 'A' && c <= 'F';
    }

    /**
     * 判断是不是钥匙
     *
     * @param c
     * @return
     */
    private boolean isKey(char c) {
        return c >= 'a' && c <= 'f';
    }

    /**
     * 判断该位置是否有效
     *
     * @param grid
     * @param i
     * @param j
     * @param m
     * @param n
     * @return
     */
    private boolean isValid(String[] grid, int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i].charAt(j) != '#';
    }

    /**
     * 存储到达某个位置拥有的钥匙 状态节点
     */
    class Node {
        int i, j, key;

        public Node(int i, int j, int key) {
            this.i = i;
            this.j = j;
            this.key = key;
        }
    }

}
