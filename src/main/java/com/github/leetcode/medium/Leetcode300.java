package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 09:27
 * @Description: Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        //不需要连续
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * nlogn
     *
     * @param nums
     * @return
     */
    public int _lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] b = new int[n + 1];
        b[0] = Integer.MIN_VALUE;
        int top = 0;
        for (int i = 0; i < n; i++) {
            int start = 0, stop = top;
            int mid;
            int j = 0;
            while (start <= stop) {
                mid = (start + stop) / 2;
                if (b[mid] < nums[i]) {
                    j = mid;
                    start = mid + 1;
                } else {
                    stop = mid - 1;
                }
            }
            b[j + 1] = nums[i];
            if (j + 1 > top) {
                top = j + 1;
            }
        }
        return top;
    }

    public int lengthOfLIS__(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * O(nlgn)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS___(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        //长度加1，保证单个元素也能找到目标元素的前一位置
        //维持一个递增数组 最长递增子序列即为最终的递增数组有效数据的长度
        int[] b = new int[n + 1];
        b[0] = Integer.MIN_VALUE;
        //b数组当前最顶部元素的下标
        int top = 0;
        for (int i = 0; i < n; i++) {
            int start = 0, stop = top;
            int mid;
            //存储目标元素的前一位置
            int j = 0;
            //二分查找
            while (start <= stop) {
                mid = start + (stop - start) / 2;
                if (b[mid] < nums[i]) {
                    start = mid + 1;
                    j = mid;
                } else {
                    stop = mid - 1;
                }
            }

            b[j + 1] = nums[i];
            top = Math.max(top, j + 1);
        }
        return top;

    }

    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS____(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        int longest = 1;
        Arrays.fill(dp, 1);
        //以元素nums[i]结尾的sequence
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(longest, dp[i]);
        }

        return longest;
    }

}
