package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/14/19 10:23
 * @Description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Lintcode117 {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && A[j] >= i - j) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jumpGreedy(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int start = 0, end = 0, jump = 0;
        while (end < len - 1) {
            jump++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                farthest = Math.max(farthest, A[i] + i);
            }
            start = end + 1;
            end = farthest;
        }
        return jump;
    }

}
