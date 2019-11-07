package com.github.lintcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/26/19 22:28
 * @Description: Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
 * <p>
 * Example
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 * <p>
 * Notice
 * There is at least one subarray that it's sum equals to zero.
 */
public class Lintcode138 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        } else {
            int len = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                if (map.containsKey(sum)) {
                    result.add(map.get(sum) + 1);
                    result.add(i);
                    return result;
                }
                map.put(sum, i);
            }
        }
        return result;
    }


    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum_(int[] nums) {
        // write your code here
        int n = nums.length;

        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(preSum[i])) {
                result.add(map.get(preSum[i]));
                result.add(i - 1);
                return result;
            } else {
                map.put(preSum[i], i);
            }
        }

        return result;
    }
}
