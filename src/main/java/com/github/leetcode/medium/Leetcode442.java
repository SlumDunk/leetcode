package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 10:32
 * @Description: Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */
public class Leetcode442 {
    public static void main(String[] args) {
        Leetcode442 leetcode442 = new Leetcode442();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        leetcode442.findDuplicates(nums);
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return resultList;
        }
        //正正得负
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                resultList.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        return resultList;
    }
}
