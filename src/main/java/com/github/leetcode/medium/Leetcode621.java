package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 15:02
 * @Description: Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 */
public class Leetcode621 {
    public static void main(String[] args) {
        Leetcode621 leetcode621 = new Leetcode621();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leetcode621.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        //存储不同task的数量
        Map<Character, Integer> taskMap = new HashMap<>();
        int len = tasks.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            taskMap.put(tasks[i], taskMap.getOrDefault(tasks[i], 0) + 1);
            max = Math.max(max, taskMap.get(tasks[i]));
        }

        int count = 0;
        for (Integer value : taskMap.values()) {
            if (value == max) {
                count++;
            }
        }
        //对max-1个空进行填充，用字母或者idle，剩下count
        int taskLength = (max - 1) * (n + 1) + count;
        if (len >= taskLength) {//不需要idle
            return len;
        } else {//需要idle填充额外的间隙
            return taskLength;
        }
    }
}
