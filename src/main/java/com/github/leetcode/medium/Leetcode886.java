package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 08:11
 * @Description: Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * <p>
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * <p>
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * Example 2:
 * <p>
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * Example 3:
 * <p>
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class Leetcode886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            adj.get(dislike[0] - 1).add(dislike[1] - 1);
            adj.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        //记录每个节点所属分组 图染色法 初始化没有颜色
        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            if (adj.get(i).size() != 0 && group[i] == 0) {
                group[i] = 1;//染成红色
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    Integer cur = q.poll();
                    for (int nei : adj.get(cur)) {
                        if (group[nei] == 0) {//相邻节点还没染色
                            group[nei] = -group[cur];//取相反颜色
                            q.offer(nei);
                        } else if (group[nei] == group[cur]) {//已经上色，查看颜色是否冲突
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
