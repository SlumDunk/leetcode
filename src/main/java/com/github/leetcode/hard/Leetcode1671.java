package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * You may recall that an array arr is a mountain array if and only if:
 * <p>
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,1]
 * Output: 0
 * Explanation: The array itself is a mountain array so we do not need to remove any elements.
 * Example 2:
 * <p>
 * Input: nums = [2,1,1,5,6,2,3,1]
 * Output: 3
 * Explanation: One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].
 * Example 3:
 * <p>
 * Input: nums = [4,3,2,1,1,2,3,1]
 * Output: 4
 * Example 4:
 * <p>
 * Input: nums = [1,2,3,4,4,3,2,1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * It is guaranteed that you can make a mountain array out of nums.
 */
public class Leetcode1671 {

    /**
     * https://www.youtube.com/watch?v=EPmzDJMkJ50
     *
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        List<Integer> leftStack = new ArrayList<>();
        List<Integer> rightStack = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = search(leftStack, nums[i]);
            if (index == leftStack.size()) {
                leftStack.add(nums[i]);
            } else {
                leftStack.set(index, nums[i]);
            }
            left[i] = index;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = search(rightStack, nums[i]);
            if (index == rightStack.size()) {
                rightStack.add(nums[i]);
            } else {
                rightStack.set(index, nums[i]);
            }
            right[i] = index;
        }

        int min = nums.length - 3;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] >= 1 && right[i] >= 1) {
                min = Math.min(min, nums.length - (left[i] + right[i] + 1));
            }
        }
        return min;
    }

    private int search(List<Integer> stack, int target) {
        int l = 0, r = stack.size();
        while (l < r) {
            int m = (r - l) / 2 + l;
            if (stack.get(m) == target) {
                return m;
            } else if (stack.get(m) < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
