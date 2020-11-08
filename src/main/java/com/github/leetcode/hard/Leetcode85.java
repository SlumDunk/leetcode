package com.github.leetcode.hard;


import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 2/20/19 21:34
 * @Description: Given a 2D binary matrix filled with 0'word and 1'word, find the largest rectangle containing only 1'word and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } else {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] height = new int[m][n + 1];
            int maxArea = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                    } else {
                        height[i][j] = 0;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                int area = maxAreaInHist(height[i]);
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }
    }

    /**
     * @param height
     * @return
     */
    private int maxAreaInHist(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int len = height.length;
        for (int i = 0; i <= len; i++) {
            int current = i == len ? -1 : height[i];
            while (!stack.isEmpty() && current <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
            stack.push(i);
        }
        return max;
    }

    /**
     * 动态规划实现
     * <p>
     * O(mn)
     * <p>
     * 底边经过(i,j)的最大长方形长度
     *
     * @param matrix
     * @return
     */
    public int maximalRectangleDP(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        } else {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] up = new int[m][n];
            int[][] left = new int[m][n];
            int[][] right = new int[m][n];
            int l, r, res = 0;
            for (int i = 0; i < m; i++) {
                //计算高度
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        up[i][j] = i == 0 ? 1 : up[i - 1][j] + 1;
                    } else {
                        up[i][j] = 0;
                    }
                }
                //计算最左边界位置
                l = 0;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '0') {
                        l = left[i][j] = 0;
                    } else {
                        l++;
                        left[i][j] = l;
                        if (i > 0 && matrix[i - 1][j] == '1') {
                            left[i][j] = Math.min(left[i - 1][j], left[i][j]);
                        }
                    }
                }

                //计算最右边界位置
                r = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (matrix[i][j] == '0') {
                        r = right[i][j] = 0;
                    } else {
                        r++;
                        right[i][j] = r;
                        if (i > 0 && matrix[i - 1][j] == '1') {
                            right[i][j] = Math.min(right[i - 1][j], right[i][j]);
                        }
                    }
                }
            }

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    res = Math.max(res, up[i][j] * (left[i][j] + right[i][j] - 1));
                }
            }

            return res;

        }
    }
}
