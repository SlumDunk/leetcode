package com.github.leetcode.medium;

import java.util.ArrayList;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 14:43
 * @Description: There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //边集合
        ArrayList[] edges = new ArrayList[numCourses];
        //初始化边集合
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        //v2->v1
        for (int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visit = new boolean[numCourses];
        //不要存在闭环即可
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edges, visit, i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param edges 边集合
     * @param visit 节点访问标志数组
     * @param pos   开始位置
     * @return
     */
    public boolean dfs(ArrayList[] edges, boolean[] visit, int pos) {
        //存在环，返回false
        if (visit[pos]) {
            return false;
        } else {
            //置为true,防止一条链上存在闭环
            visit[pos] = true;
        }
        for (int i = 0; i < edges[pos].size(); i++) {
            if (!dfs(edges, visit, (int) edges[pos].get(i))) {
                return false;
            }
            //移除走过的边
            edges[pos].remove(i);
        }
        //这一路走完了，访问标志置为false，因为可能它有其它入度
        visit[pos] = false;
        return true;
    }

}

