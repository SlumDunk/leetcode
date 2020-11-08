package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 16:57
 * @Description: Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Return the sum of all odd-length subarrays of arr.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,4,2,5,3]
 * Output: 58
 * Explanation: The odd-length subarrays of arr and their sums are:
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: 3
 * Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
 * Example 3:
 * <p>
 * Input: arr = [10,11,12]
 * Output: 66
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 */
public class Leetcode1558 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            int width = 0;
            for (int j = 0; j < i; j++) {
                width += arr[j];
            }
            sum += width;
            for (int j = i; j < n; j++) {
                width += arr[j];
                width -= arr[j - i];
                sum += width;
            }
        }
        return sum;
    }
}
