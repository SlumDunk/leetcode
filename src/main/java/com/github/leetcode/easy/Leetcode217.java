package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/15/18 16:41
 * @Description: Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if(len<2){
            return false;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < len; i++) {
            if (numMap.get(nums[i]) != null) {
                return true;
            }else{
                numMap.put(nums[i],1);
            }
        }
        return false;
    }
}
