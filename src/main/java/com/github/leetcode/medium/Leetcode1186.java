package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 17:56
 * @Description: Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.
 * <p>
 * Note that the subarray needs to be non-empty after deleting one element.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,-2,0,3]
 * Output: 4
 * Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 * Example 2:
 * <p>
 * Input: arr = [1,-2,-2,3]
 * Output: 3
 * Explanation: We just choose [3] and it's the maximum sum.
 * Example 3:
 * <p>
 * Input: arr = [-1,-1,-1,-1]
 * Output: -1
 * Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
public class Leetcode1186 {
    public static void main(String[] args) {
        Leetcode1186 leetcode1186 = new Leetcode1186();
        leetcode1186.maximumSum(new int[]{1, -2, 0, 3});
    }

    public int maximumSum(int[] arr) {
        if (arr.length == 1) return arr[0];
        int n = arr.length;

        int[] dpEnd = new int[n];

        int[] dpStart = new int[n];

        dpEnd[0] = arr[0];
        dpStart[n - 1] = arr[n - 1];
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            dpEnd[i] = dpEnd[i - 1] > 0 ? dpEnd[i - 1] + arr[i] : arr[i];
            max = Math.max(max, dpEnd[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            dpStart[i] = dpStart[i + 1] > 0 ? dpStart[i + 1] + arr[i] : arr[i];
        }

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] < 0) {
                max = Math.max(max, dpEnd[i - 1] + dpStart[i + 1]);
            }
        }
        return max;
    }
}
