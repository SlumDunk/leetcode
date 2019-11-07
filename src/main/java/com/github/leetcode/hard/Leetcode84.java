package com.github.leetcode.hard;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 16:06
 * @Description: Given n non-negative integers representing the histogram'word bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class Leetcode84 {
    public int largestRectangleArea(int[] heights) {
        //找第一个比自己小的左边界，右边界
        //组成的面积是heights[i]*(right[i]-left[i]-1)
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        right[len - 1] = len;

        //左边界，从前往后扫
        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];
            }
            left[i] = p;
        }

        //右边界，从后往前扫
        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[p] >= heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }
        return max;
    }


    /**
     * O(N)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea_(int[] heights) {
        //维护一个单调递增栈
        int n = heights.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? -1 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
