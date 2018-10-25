package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 16:10
 * @Description: There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3] . Another correct ordering is [0,2,1,3] .
 */
public class Leetcode210 {
    public static void main(String[] args) {
        Leetcode210 leetcode210 = new Leetcode210();
        leetcode210.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> edges[] = new ArrayList[numCourses];
        boolean[] visit = new boolean[numCourses];
        int[] out_degree = new int[numCourses];
        int[] ans = new int[numCourses];
        int n = numCourses;
        for (int i = 0; i < numCourses; ++i)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; ++i) {
            int v1 = prerequisites[i][0];
            int v2 = prerequisites[i][1];
            edges[v1].add(v2);
            ++out_degree[v2];
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i)
            if (out_degree[i] == 0)
                q.add(i);
        while (q.isEmpty() != true) {
            int v = q.poll();
            visit[v] = true;
            ans[--n] = v;
            for (int i : edges[v]) {
                --out_degree[i];
                if (out_degree[i] == 0)
                    q.add(i);
            }
        }
        for (int i = 0; i < numCourses; ++i)
            if (visit[i] == false) {
                ans = new int[0];
                return ans;
            }
        return ans;
    }
}
