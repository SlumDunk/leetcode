package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 08:47
 * @Description: Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 那么如果某一个数x发生了重复，那么遍历这个数组，一定能找到至少x+1个数小于等于x
 */
public class Leetcode287 {
    public static void main(String[] args) {
        Leetcode287 leetcode287 = new Leetcode287();
        leetcode287.findDuplicate(new int[]{2, 2, 4, 1, 3});
    }

    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length;
        while (right > left) {
            int amount = 0;
            int middle = (left + right) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= middle) {
                    amount++;
                }
            }
            if (amount > middle) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }
        return left;
    }
}
