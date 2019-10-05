package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 10:07
 * @Description: Given an integer array arr and an integer k, modify the array by repeating it k times.
 * <p>
 * For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
 * <p>
 * Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
 * <p>
 * As the answer can be very large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2], k = 3
 * Output: 9
 * Example 2:
 * <p>
 * Input: arr = [1,-2,1], k = 5
 * Output: 2
 * Example 3:
 * <p>
 * Input: arr = [-1,-2], k = 7
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
public class Leetcode1191 {

    public int kConcatenationMaxSum(int[] arr, int k) {

        int modulo = 1000000007;
        int n = arr.length;
        int maxSoFar = Math.max(0, arr[0]);
        int maxEndHere = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndHere = Math.max(maxEndHere + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }

        if (k < 2) return maxSoFar;
        //从左往右连续累加和
        int leftSum = arr[0];
        //从右往左连续累加和
        int rightSum = arr[n - 1];
        //从左往右最大连续累加和
        int lMax = Math.max(0, arr[0]);
        //从右往左最大连续累加和
        int rMax = Math.max(0, arr[n - 1]);

        for (int i = 1; i < n; i++) {
            leftSum += arr[i];
            lMax = Math.max(lMax, leftSum);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightSum += arr[i];
            rMax = Math.max(rMax, rightSum);
        }

        int headTailMax = lMax + rMax;

        if (leftSum < 0) {
            return Math.max(maxSoFar, headTailMax);
        } else {
            return Math.max(maxSoFar, (int) (headTailMax + ((k - 2) * (long) leftSum) % modulo));
        }
    }
}
