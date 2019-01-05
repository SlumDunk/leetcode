package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 19:03
 * @Description: Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class Leetcode42 {
    public static void main(String[] args) {
        Leetcode42 leetcode42 = new Leetcode42();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        leetcode42.trap(height);
    }

    public int trap(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        //存储每个位置的左右边界
        int[] left = new int[len];
        int[] right = new int[len];
        int result = 0;
        //从左往右走
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        //从右往左走
        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
