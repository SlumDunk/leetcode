package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/25/18 14:38
 * @Description: Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class Leetcode11 {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int result = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                int k = left;
                while (k < right && height[k] <= height[left]) {
                    k++;
                }
                left = k;
            } else {
                int k = right;

                while (k > left && height[k] <= height[right]) {
                    k--;
                }
                right = k;
            }

        }
        return result;
    }
}
