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
        //利用数组的元素取值范围不超过数组的长度，且只有一个元素重复的特性
        int len = nums.length;
        //用正负性质来判断元素出现的次数
        for (int i = 0; i < len; i++) {
            //要变更符号的元素的位置
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                resultList.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return resultList;
    }
}
