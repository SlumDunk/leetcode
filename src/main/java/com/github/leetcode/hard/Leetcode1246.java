package com.github.leetcode.hard;

/**
 * Given an integer array arr, in one move you can select a palindromic subarray arr[i], arr[i+1], ..., arr[j] where i <= j, and remove that subarray from the given array. Note that after removing a subarray, the elements on the left and on the right of that subarray move to fill the gap left by the removal.
 * <p>
 * Return the minimum number of moves needed to remove all numbers from the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: arr = [1,3,4,1,5]
 * Output: 3
 * Explanation: Remove [4] then remove [1,3,1] then remove [5].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 20
 */
public class Leetcode1246 {
    public int minimumMoves(int[] arr) {
        // dp[i][j] 1,2,3
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = arr.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0, j = i + l - 1; j < len; i++, j++) {
                int min = Integer.MAX_VALUE;
                if (arr[i] == arr[j]) {
                    min = Math.min(min, dp[i + 1][j - 1]);
                }

                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 1, 5};
        Leetcode1246 leetcode1246 = new Leetcode1246();
        leetcode1246.minimumMoves(arr);
    }
}
