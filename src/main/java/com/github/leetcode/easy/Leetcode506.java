package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 * <p>
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 */
public class Leetcode506 {
    public static void main(String[] args) {

    }

    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(64);
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] result = new String[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            switch (j) {
                case 0:
                    result[indexMap.get(nums[i])] = "Gold Medal";
                    break;
                case 1:
                    result[indexMap.get(nums[i])] = "Silver Medal";
                    break;

                case 2:
                    result[indexMap.get(nums[i])] = "Bronze Medal";
                    break;
                default:
                    result[indexMap.get(nums[i])] = String.valueOf(j + 1);
                    break;


            }
        }

        return result;
    }
}

