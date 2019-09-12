package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 08:31
 * @Description: There are N courses, labelled from 1 to N.
 * <p>
 * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
 * <p>
 * In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
 * <p>
 * Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: N = 3, relations = [[1,3],[2,3]]
 * Output: 2
 * Explanation:
 * In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: N = 3, relations = [[1,2],[2,3],[3,1]]
 * Output: -1
 * Explanation:
 * No course can be studied because they depend on each other.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 5000
 * 1 <= relations.length <= 5000
 * relations[i][0] != relations[i][1]
 * There are no repeated relations in the input.
 */
public class Leetcode1136 {
    public static void main(String[] args) {
        Leetcode1136 leetcode1136 = new Leetcode1136();
        int[][] relations = {{1, 3}, {2, 3}};
        System.out.println(leetcode1136.minimumSemesters(3, relations));
    }

    /**
     * 拓扑排序能自动检测环 若队列空了，但是还有节点没访问，则表示图里有环
     *
     * @param N
     * @param relations
     * @return
     */
    public int minimumSemesters(int N, int[][] relations) {
        //build graph relationship

        //key为课程号 value 为先修课
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        //key 为先修课课程号， value为依赖于该先修课的list
        Map<Integer, List<Integer>> helpMap = new HashMap<Integer, List<Integer>>();


        for (int[] relation : relations) {
            List<Integer> listPrerequisites = graph.getOrDefault(relation[1], new ArrayList<Integer>());
            listPrerequisites.add(relation[0]);
            graph.put(relation[1], listPrerequisites);

            List<Integer> listNext = helpMap.getOrDefault(relation[0], new ArrayList<Integer>());
            listNext.add(relation[1]);
            helpMap.put(relation[0], listNext);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        int res = N;
        Set<Integer> keySet = graph.keySet();
        for (int i = 1; i <= N; i++) {
            if (!keySet.contains(i)) {
                res--;
                queue.add(i);
            }
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer item = queue.poll();
                List<Integer> next = helpMap.get(item);
                if (next != null && next.size() > 0) {
                    for (Integer key : next) {
                        graph.get(key).remove(item);
                        if (graph.get(key).size() == 0) {
                            res--;
                            queue.offer(key);
                        }
                    }
                }
                size--;
            }
            result++;
        }

        return res == 0 ? result : -1;
    }
}
