package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 14:49
 * @Description: Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */
public class Leetcode611 {
    public int triangleNumber(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        } else {
            int count = 0;
            Arrays.sort(nums);
            for (int i = len - 1; i >= 2; i--) {
                int left = 0, right = i - 1;
                while (left < right) {
                    if (nums[left] + nums[right] > nums[i]) {//left和right之间的元素和right都可以组建成三角形的另外两条边
                        count += right - left;
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return count;
        }
    }
}
