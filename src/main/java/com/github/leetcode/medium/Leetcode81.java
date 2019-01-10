package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 09:24
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class Leetcode81 {
    public static void main(String[] args) {
        Leetcode81 leetcode81 = new Leetcode81();
        System.out.println(leetcode81.search(new int[]{3, 1}, 1));
    }

    public boolean search(int[] nums, int target) {
        // 这个问题在面试中不会让实现完整程序
        // 只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
        // 在这种情况下是无法使用二分法的，复杂度是O(n)
        // 因此写个for循环最坏也是O(n)，那就写个for循环就好了
        //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
        //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }
}
