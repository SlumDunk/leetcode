package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 20:09
 * @Description: A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 * Example 2:
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * Example 3:
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 */
public class Leetcode376 {
    public static void main(String[] args) {
        Leetcode376 leetcode376 = new Leetcode376();
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 18};
        leetcode376.dpWiggleMaxLength(nums);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1])
                up = down + 1;
            else if (nums[i] < nums[i - 1])
                down = up + 1;

        return Math.max(up, down);
    }

    public int dpWiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //到当前位置的最长摆动子序列长度 方向向上 或 方向向下
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {//up
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i - 1][1];
            } else if (nums[i] < nums[i - 1]) {//down
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }

        int index = nums.length - 1;
        int nextVal;
        if (dp[index][0] > dp[index][1]) {
            nextVal = Integer.MIN_VALUE;
        } else {
            nextVal = Integer.MAX_VALUE;
        }
        while (index >= 0) {
            if (dp[index][0] > dp[index][1]) {//最后一个方向是up
                if (index == 0) {
                    System.out.printf(nums[index] + " ");
                } else if (dp[index][0] >= dp[index - 1][0] && nums[index] > nextVal) {
                    System.out.printf(nums[index] + " ");
                    nextVal = nums[index];
                }

            } else {//最后一个方向是down
                if (index == 0) {
                    System.out.printf(nums[index] + " ");
                } else if (dp[index][1] >= dp[index - 1][1] && nums[index] < nextVal) {
                    System.out.printf(nums[index] + " ");
                    nextVal = nums[index];
                }
            }
            index--;
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
