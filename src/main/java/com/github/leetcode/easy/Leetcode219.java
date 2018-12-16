package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/15/18 16:54
 * @Description: Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //保存最后一次出现的位置
        Map<Integer, Integer> numMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer value = numMap.getOrDefault(nums[i], -1);
            if (value >= 0) {
                if (i - value <= k) {//只要有其中两个位置满足就可以了
                    return true;
                }
            }
            numMap.put(nums[i], i);//更新最新一次出现的位置
        }
        return false;
    }
}
