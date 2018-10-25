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

        ArrayList[] list = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visit = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(list, visit, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList[] list, boolean[] visit, int pos) {
        if (visit[pos]) {
            return false;
        } else {
            visit[pos] = true;
        }
        for (int i = 0; i < list[pos].size(); i++) {
            if (!dfs(list, visit, (int) list[pos].get(i))) {
                return false;
            }
            list[pos].remove(i);
        }
        visit[pos] = false;
        return true;
    }

}

