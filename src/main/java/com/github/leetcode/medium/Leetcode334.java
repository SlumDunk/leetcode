package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 21:35
 * @Description: Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class Leetcode334 {
    public boolean increasingTriplet(int[] nums) {
        // 记录目前为止最小的数字
        int min = Integer.MAX_VALUE;
        // 记录目前为止第二小的数字
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
                // min最小的数字
            if (n <= min)
                min = n;
                // n>min,但是比min2小，更新
            else if (n <= min2)
                min2 = n;
            else
                // n>min2>min返回true
                return true;
        }
        return false;
    }
}
