package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 09:08
 * @Description: Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned frequency is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 */
public class Leetcode80 {
    public int removeDuplicates(int[] nums) {
        //数组是有序的，只要比较连续的三个数字即可
        //数组为空
        if (nums == null) return 0;
        //数组长度小于3
        if (nums.length <= 2) return nums.length;
        //前两个数先放进新数组，不违规
        int len = 2;
        //从第三个数开始
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[len - 1] && nums[len - 1] == nums[len - 2]) {//连续三个数字一样，跳过，继续往前走

            } else {
                nums[len] = nums[i];//放进新元素
                len++;//下个元素要放的位置
            }
        }
        return len;
    }
}
