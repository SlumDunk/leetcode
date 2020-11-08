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
        } else {
            //双指针，一点点往里收缩
            int left = 0;
            int right = height.length - 1;
            int tmpHeight;
            int max = 0;
            while (left < right) {//保持最高的那条边
                if (height[left] <= height[right]) {
                    tmpHeight = height[left];
                    max = Math.max(max, tmpHeight * (right - left));
                    left++;
                } else {
                    tmpHeight = height[right];
                    max = Math.max(max, tmpHeight * (right - left));
                    right--;
                }
            }
            return max;
        }
    }


    /**
     * O(n)
     *
     * @param height
     * @return
     */
    public int maxArea_(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int left = 0, right = n - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
