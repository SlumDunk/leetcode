package com.github.leetcode.medium;

import java.util.*;

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
        //1->0
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

    /**
     * 广度优先搜索
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean bfsCanFinish(int numCourses, int[][] prerequisites) {
        //图
        ArrayList[] graph = new ArrayList[numCourses];
        //各节点的入度
        int[] degree = new int[numCourses];
        //队列
        Queue queue = new LinkedList();
        int count = 0;
        //初始化边集合
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();
        //构造边集合
        for (int i = 0; i < prerequisites.length; i++) {
            //0->1
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //入度为0的节点先入队列，表示可以先上
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (queue.size() != 0) {
            int course = (int) queue.poll();
            //修正关联节点的入度
            for (int i = 0; i < graph[course].size(); i++) {
                int adjVertex = (int) graph[course].get(i);
                degree[adjVertex]--;
                //入度为0，加入队列
                if (degree[adjVertex] == 0) {
                    queue.add(adjVertex);
                    count++;
                }
            }
        }
        //所有课程都修完
        if (count == numCourses)
            return true;
        else
            return false;
    }


    /**
     * O(n)
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish_(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int v = pre[0];
            int u = pre[1];

            degree[v]++;
            List<Integer> valueList = graph.getOrDefault(u, new ArrayList<>());
            valueList.add(v);
            graph.put(u, valueList);
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();
            List<Integer> edges = graph.getOrDefault(course, new ArrayList<>());
            for (int i = 0; i < edges.size(); i++) {
                int v = edges.get(i);
                if (--degree[v] == 0) {
                    queue.add(v);
                    count++;
                }
            }
        }

        if (count == numCourses) {
            return true;
        } else {
            return false;
        }
    }
}

