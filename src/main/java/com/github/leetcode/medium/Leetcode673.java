package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 15:22
 * @Description: Given an unsorted array of integers, find the number of longest increasing subsequence.
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class Leetcode673 {
    /**
     * Logical Thinking
     * State
     * length[i] as length of LIS ending at nums[i];
     * count[i] as number of LIS ending at nums[i];
     * Aim state
     * sum(count[index]) for index is from indicesMaxLength. indicesMaxLength save indices that satisfy maxLength, the length of LIS for the whole array.
     * State transition
     * for nums[j], 0 <= i < j,
     * if nums[j] > nums[i],
     * <p>
     * if (length[i] >= length[j]) {
     * length[j] = length[i] + 1;
     * count[j] = count[i];
     * }
     * else if (length[i] == length[j] - 1) {
     * count[j] += count[i];
     * }
     * Please note that the initial value of elements in count[] is 1.
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length, result = 0;
        int[] length = new int[len], count = new int[len];
        Arrays.fill(count, 1);

        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    if (length[i] >= length[j]) {
                        length[j] = length[i] + 1;
                        count[j] = count[i];
                    } else if (length[i] == length[j] - 1) {
                        count[j] += count[i];
                    }
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < len; i++) {
            if (length[i] > maxLength) {
                maxLength = length[i];
            }
        }
        List<Integer> indicesMaxLength = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (length[i] == maxLength) {
                indicesMaxLength.add(i);
            }
        }
        for (int index : indicesMaxLength) {
            result += count[index];
        }

        return result;
    }


    public int findNumberOfLIS__(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        } else {
            int[] dp = new int[len];
            int[] routes = new int[len];
            dp[0] = 1;
            routes[0] = 1;
            int max = 1;

            for (int i = 1; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                max = Math.max(dp[i], max);
                //获取前面有多少条可以到达目的的路径
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[j] + 1 == dp[i]) {
                            routes[i] += routes[j];
                        }
                    }
                }
                //前面没有路径可达，只有本身构成subarray
                if (routes[i] == 0) {
                    routes[i] = 1;
                }
            }
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (dp[i] == max) {
                    count += routes[i];
                }
            }

            return count;
        }
    }
}
