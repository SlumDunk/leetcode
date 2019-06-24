package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 12:43
 * @Description: Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * <p>
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * <p>
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.
 * <p>
 * Example 1:
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * <p>
 * Output: 4
 * <p>
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 * Note:
 * You may assume all numbers in the input are non-negative integers.
 * The length of Profits array and Capital array will not exceed 50,000.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class Leetcode502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int[][] ps = new int[Profits.length][2];
        for (int i = 0; i < Profits.length; i++) {
            ps[i] = new int[]{Capital[i], Profits[i]};
        }
        // sort by captial 按启动工程所需要的资本从小到大排序
        Arrays.sort(ps, (a, b) -> a[0] - b[0]);

        // sort by profits 按利润从高到低排序 存放现在能够启动的工程
        PriorityQueue<Integer> q = new PriorityQueue<>(ps.length, (a, b) -> b - a);
        //遍历所有工程
        for (int i = 0; i < ps.length && k > 0; i++) {
            int[] p = ps[i];
            if (W >= p[0]) {//拥有的资本大于等于启动该工程所需要的资本
                q.add(p[1]);
                continue;
            }
            while (k > 0 && !q.isEmpty() && W < p[0]) {
                W += q.poll();
                k--;
            }
            if (W >= p[0]) {
                q.add(p[1]);
            }
        }
        while (k > 0 && !q.isEmpty()) {
            W += q.poll();
            k--;
        }
        return W;
    }
}
