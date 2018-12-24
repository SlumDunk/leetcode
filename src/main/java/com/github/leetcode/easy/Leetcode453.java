package com.github.leetcode.easy;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p>
 * Example:
 * <p>
 * Input:
 * [1,2,3]
 * <p>
 * Output:
 * 3
 * <p>
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class Leetcode453 {
    public static void main(String[] args) {

    }

    public int minMoves(int[] nums) {
        //假设初始和尾s,经过k次移动后，和值为s+(n-1)*k, 平均值为(s+(n-1)*k)/n, 最小值为min
        // k=s-min*n
        int min = Integer.MAX_VALUE, res = 0;
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            sum += nums[i];
        }

        res = sum - min * len;
        return res;
    }
}
