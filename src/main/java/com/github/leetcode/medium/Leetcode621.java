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
        Map<Character, Integer> map = new HashMap<>();//char array is better, I just want to make this answer easier to read.
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;//Most frequent task.
        for (int val : map.values()) {
            max = Math.max(val, max);
        }

        int p = 0;//how many tasks that has the same frequency as the top frequent task.(include itself)
        for (int val : map.values()) {
            if (val == max) {
                p++;
            }
        }

        int total = (max - 1) * (n + 1) + p;//Totally intervals to fill out all empty space.

        if (total < tasks.length) {
            return tasks.length; //After I fill out all empty space, there are still some tasks that I have not use them.
        } else {
            return total; //Task is not enough, I used some idles.
        }
    }
}
