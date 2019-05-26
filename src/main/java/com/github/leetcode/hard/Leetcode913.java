package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/24/19 22:07
 * @Description: A game on an undirected graph is played by two players, Mouse and Cat, who alternate turns.
 * <p>
 * The graph is given as follows: graph[a] is a list of all nodes b such that ab is an edge of the graph.
 * <p>
 * Mouse starts at node 1 and goes first, Cat starts at node 2 and goes second, and there is a Hole at node 0.
 * <p>
 * During each player's turn, they must travel along one edge of the graph that meets where they are.  For example, if the Mouse is at node 1, it must travel to any node in graph[1].
 * <p>
 * Additionally, it is not allowed for the Cat to travel to the Hole (node 0.)
 * <p>
 * Then, the game can end in 3 ways:
 * <p>
 * If ever the Cat occupies the same node as the Mouse, the Cat wins.
 * If ever the Mouse reaches the Hole, the Mouse wins.
 * If ever a position is repeated (ie. the players are in the same position as a previous turn, and it is the same player's turn to move), the game is a draw.
 * Given a graph, and assuming both players play optimally, return 1 if the game is won by Mouse, 2 if the game is won by Cat, and 0 if the game is a draw.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * Output: 0
 * Explanation:
 * 4---3---1
 * |   |
 * 2---5
 * \ /
 * 0
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= graph.length <= 50
 * It is guaranteed that graph[1] is non-empty.
 * It is guaranteed that graph[2] contains a non-zero element.
 */
public class Leetcode913 {
    /**
     * 0 unvisited, 1 mouse turn, 2 cat turn
     */
    int[][][] color;

    /**
     * 从结果往前推
     *
     * @param graph
     * @return
     */
    public int catMouseGame(int[][] graph) {
        int N = graph.length;
        color = new int[N][N][3];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int t = 1; t <= 2; t++) {
                //只有老鼠能过0点，老鼠赢
                color[0][i][t] = 1;
                queue.offer(new int[]{0, i, t});
                if (i == 0) continue;
                //猫和老鼠都在节点i相遇，猫赢
                color[i][i][t] = 2;
                queue.offer(new int[]{i, i, t});
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int m = tmp[0], c = tmp[1], t = tmp[2], state = color[m][c][t];
            for (int[] p :
                    findParents(graph, m, c, t)) {
                if (color[p[0]][p[1]][p[2]] != 0) continue;
//                if (t == 1 && state == 2) {//老鼠走，猫赢
//                    color[p[0]][p[1]][p[2]] = state;
//                queue.offer(new int[]{p[0], p[1], p[2]});
//                } else if (t == 2 && state == 1) {//猫走，老鼠赢
//                    color[p[0]][p[1]][p[2]] = state;
//                queue.offer(new int[]{p[0], p[1], p[2]});
//                }
                if (p[2] == state) {
                    color[p[0]][p[1]][p[2]] = state;
                    queue.offer(new int[]{p[0], p[1], p[2]});
                } else if (allChildWin(graph, p[0], p[1], p[2])) {
                    color[p[0]][p[1]][p[2]] = p[2] == 1 ? 2 : 1;
                    queue.offer(new int[]{p[0], p[1], p[2]});
                }
            }
        }
        return color[1][2][1];
    }

    /**
     * @param graph
     * @param m
     * @param c
     * @param t
     * @return
     */
    private boolean allChildWin(int[][] graph, int m, int c, int t) {
        if (t == 1) {//当前是老鼠移动
            for (int mc :
                    graph[m]) {
                if (color[mc][c][2] != 2) {
                    return false;
                }
            }
        } else {//当前是猫移动
            for (int cc :
                    graph[c]) {
                if (cc != 0 && color[m][cc][1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 找到前一状态
     *
     * @param graph
     * @param m
     * @param c
     * @param t
     * @return
     */
    private List<int[]> findParents(int[][] graph, int m, int c, int t) {
        List<int[]> res = new ArrayList<>();
        if (t == 1) {// current mouse move, previous cat move
            for (int cp :
                    graph[c]) {
                if (cp != 0) {
                    res.add(new int[]{m, cp, 2});
                }
            }
        } else {// current cat move, previous mouse move
            for (int mp : graph[m]) res.add(new int[]{mp, c, 1});
        }
        return res;
    }
}
