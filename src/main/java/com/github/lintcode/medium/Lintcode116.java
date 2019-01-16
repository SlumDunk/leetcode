package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/14/19 10:06
 * @Description: Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 * <p>
 * Notice
 * This problem have two method which is Greedy and Dynamic Programming.
 * <p>
 * The time complexity of Greedy method is O(n).
 * <p>
 * The time complexity of Dynamic Programming method is O(n^2).
 * <p>
 * We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 */
public class Lintcode116 {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        int len = A.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && A[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJumpGreedy(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        int len = A.length;
        int farthest = A[0];
        //要先能到达位置i
        for (int i = 1; i < len && farthest >= i; i++) {
            farthest = Math.max(farthest, i + A[i]);
            //可以到达末尾
            if (farthest >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
