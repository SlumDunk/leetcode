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
        //边集合
        List<Integer> edges[] = new ArrayList[numCourses];
        //访问标记数组
        boolean[] visit = new boolean[numCourses];
        //入度数组
        int[] in_degree = new int[numCourses];
        //结果集
        int[] ans = new int[numCourses];
        int index = 0;
        //初始化边集合
        for (int i = 0; i < numCourses; ++i)
            edges[i] = new ArrayList<>();
        //
        for (int i = 0; i < prerequisites.length; ++i) {
            //v2->v1
            int v1 = prerequisites[i][0];
            int v2 = prerequisites[i][1];
            edges[v2].add(v1);
            ++in_degree[v1];
        }
        Queue<Integer> q = new LinkedList<>();
        //入度为0的课程先入队列 最先开始
        for (int i = 0; i < numCourses; ++i)
            if (in_degree[i] == 0)
                q.add(i);

        while (q.isEmpty() != true) {
            int v = q.poll();
            //设置为已访问
            visit[v] = true;
            //放在所在的位置
            ans[index++] = v;
            //调整关联的节点的入度
            for (int i : edges[v]) {
                --in_degree[i];
                if (in_degree[i] == 0)
                    q.add(i);
            }
        }
        //判断是否所有的课程都已经修了
        for (int i = 0; i < numCourses; ++i)
            if (visit[i] == false) {
                ans = new int[0];
                return ans;
            }
        return ans;
    }
}
