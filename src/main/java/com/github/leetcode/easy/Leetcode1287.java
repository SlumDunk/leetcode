package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/1/20 20:30
 * @Description: Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.
 * <p>
 * Return that integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class Leetcode1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int num = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > num) {
                num = arr[i];
                count = 1;
            } else {
                count++;
            }
            if (count > (n / 4)) {
                break;
            }
        }
        return num;
    }
}
