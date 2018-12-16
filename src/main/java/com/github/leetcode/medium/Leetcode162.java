package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:44
 * @Description: A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 */
public class Leetcode162 {
    public static void main(String[] args) {
        Leetcode162 leetcode162 = new Leetcode162();
        System.out.println(leetcode162.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 7}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {//left和right同个位置，只剩一个元素
            int mid = (left + right) / 2;
            //每次二分查找总往大值的位置靠近
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

}
