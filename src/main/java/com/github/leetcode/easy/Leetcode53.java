package com.github.leetcode.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else {
            int len = nums.length;
            //跟前面拼一起的累积和，以及不跟前面拼一起的累积和
            int[][] dp = new int[len][2];
            dp[0][0] = nums[0];
            dp[0][1] = nums[0];
            int max = Math.max(dp[0][0], dp[0][1]);
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + nums[i];
                dp[i][1] = nums[i];
                max = Math.max(dp[i][1], Math.max(dp[i][0], max));
            }
            return max;
        }
    }

    /**
     * O(NlgN) left sub sum, right sub sum, cross sub sum
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        //左边最大连续和
        int leftSub = maxSubArraySum(nums, left, mid);
        //右边最大连续和
        int rightSub = maxSubArraySum(nums, mid + 1, right);

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        //包含中间点求最大连续和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        int subResult = Math.max(leftSub, rightSub);

        return Math.max(subResult, leftSum + rightSum);
    }


    /**
     * O(N) TC
     * O(1) SC
     *
     * @param nums
     * @return
     */
    public int maxSubArray_(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < len; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            max = Math.max(max, curSum);
        }
        return max;
    }


    /**
     * Initialize:
     * max_so_far = 0
     * max_ending_here = 0
     * <p>
     * Loop for each element of the array
     * (a) max_ending_here = max_ending_here + a[i]
     * (b) if(max_ending_here < 0)
     * max_ending_here = 0
     * (c) if(max_so_far < max_ending_here)
     * max_so_far = max_ending_here
     * return max_so_far
     *
     * @param nums
     * @return
     */
    public int maxSubArray__(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndHere = 0;
        int start = 0, end = 0;

        int s = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEndHere += nums[i];
            if (maxSoFar < maxEndHere) {
                maxSoFar = maxEndHere;
                start = s;
                end = i;
            }
            if (maxEndHere < 0) {
                maxEndHere = 0;
                s = i + 1;
            }
        }
        System.out.println("start:" + start + ", end:" + end);
        return maxSoFar;
    }
}
