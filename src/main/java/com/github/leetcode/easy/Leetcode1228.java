package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/25/20 20:10
 * @Description: In some array arr, the values were in arithmetic progression: the values arr[i+1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
 * <p>
 * Then, a value from arr was removed that was not the first or last value in the array.
 * <p>
 * Return the removed value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [5,7,11,13]
 * Output: 9
 * Explanation: The previous array was [5,7,9,11,13].
 * Example 2:
 * <p>
 * Input: arr = [15,13,12]
 * Output: 14
 * Explanation: The previous array was [15,14,13,12].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= arr.length <= 1000
 * 0 <= arr[i] <= 10^5
 */
public class Leetcode1228 {
    public int missingNumber(int[] arr) {
        int n = arr.length + 1;
        int expected_sum = (n * (arr[0] + arr[arr.length - 1])) / 2;
        int actual_sum = 0;
        for (int num : arr)
            actual_sum += num;
        return expected_sum - actual_sum;
    }
}
