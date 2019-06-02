package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 20:35
 * @Description: You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * <p>
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class Leetcode494 {
    /**
     * -sum~sum, 2*sum+1
     *O(n*sum)
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num :
                nums) {
            sum += num;
        }
        if (sum < S) return 0;
        int kOffset = sum;
        int kMaxN = sum * 2 + 1;
        int[] ways = new int[kMaxN];
        ways[kOffset] = 1;
        for (int num :
                nums) {
            int[] tmp = new int[kMaxN];
            for (int i = num; i < kMaxN - num; i++) {
                tmp[i + num] += ways[i];
                tmp[i - num] += ways[i];
            }
            ways = tmp;
        }
        return ways[S + kOffset];
    }
}
