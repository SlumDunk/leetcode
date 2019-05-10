package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 12:20
 * @Description: Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class Leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<int[]>();
        int[] ret = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < T[i]) {
                int[] tmp = stack.pop();
                ret[tmp[1]] = i - tmp[1];
            }
            stack.push(new int[]{T[i], i});
        }
        return ret;
    }
}
