package com.github.lintcode.hard;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/25/19 09:34
 * @Description: Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * histogram
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * histogram
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * Example
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class Lintcode122 {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        //维护一个最小递增栈
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int current = i == len ? -1 : height[i];
            while (!stack.isEmpty() && current <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
