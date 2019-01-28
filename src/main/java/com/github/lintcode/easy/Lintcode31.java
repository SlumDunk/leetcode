package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 22:09
 * @Description: Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * <p>
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * <p>
 * Example
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * <p>
 * Challenge
 * Can you partition the array in-place and in O(n)?
 * <p>
 * Notice
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 * <p>
 * If all elements in nums are smaller than k, then return nums.length
 */
public class Lintcode31 {
    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            int i = 0, j = len - 1;
            while (i < j) {
                while (i < len && nums[i] < k) {
                    i++;
                }
                while (j >= 0 && nums[j] >= k) {
                    j--;
                }
                if (i < j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    i++;
                    j--;
                } else {
                    break;
                }
            }

            for (i = 0; i < len; i++) {
                if (nums[i] >= k) {
                    return i;
                }
            }
            return len;
        }
    }
}
