package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 08:26
 * @Description: Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * <p>
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
 * <p>
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
 * <p>
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
 * <p>
 * Example 1:
 * Input:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation:
 * 3
 * /   \
 * 1     5
 * /
 * 10
 * Kill 5 will also kill 10.
 * Note:
 * The given kill id is guaranteed to be one of the given PIDs.
 * n >= 1.
 */
public class Leetcode582 {
    /**
     * bfs
     * @param pid
     * @param ppid
     * @param kill
     * @return
     */
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //key为父进程，value为子进程列表
        HashMap<Integer, List<Integer>> childerns = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++)
            childerns.computeIfAbsent(ppid.get(i), key -> new ArrayList<>()).add(pid.get(i));

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);

        while (!queue.isEmpty()) {
            int id = queue.poll();
            res.add(id);

            for (int ch : (List<Integer>) (childerns.get(id) == null ? new ArrayList<>() : childerns.get(id))) {
                queue.offer(ch);
            }
        }
        return res;
    }
}
