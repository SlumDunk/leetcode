package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 19:17
 * @Description: Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,6,4,1]
 * Output: false
 * Explanation: There are no three consecutive odds.
 * Example 2:
 * <p>
 * Input: arr = [1,2,34,3,4,5,7,23,12]
 * Output: true
 * Explanation: [5,7,23] are three consecutive odds.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 */
public class Leetcode1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;

    }
}
