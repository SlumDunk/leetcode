package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 16:27
 * @Description: Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class Leetcode1051 {
    public int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                num++;
            }
        }
        return num;
    }
}
