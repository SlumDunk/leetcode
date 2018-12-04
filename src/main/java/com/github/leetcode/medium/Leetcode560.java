package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 11:23
 * @Description: Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class Leetcode560 {
    public static void main(String[] args) {
        Leetcode560 leetcode560 = new Leetcode560();
        int[] nums = {-1, -1, 1};
        int k = 0;
        System.out.println(leetcode560.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int[] sumarray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                sumarray[i] += nums[i] + sumarray[i - 1];
            } else {
                sumarray[i] += nums[i];
            }
        }
        int total = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sumarray[j] - sumarray[i] + nums[i] == k) {
                    total++;
                }
            }
        }
        return total;
    }

    public int optimizeSubarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int total = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                total += map.get(sum - k);
            } else {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return total;
    }
}
