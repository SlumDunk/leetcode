package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 08:19
 * @Description: Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.
 * <p>
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [6,0,8,2,1,5]
 * Output: 4
 * Explanation:
 * The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
 * Example 2:
 * <p>
 * Input: [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation:
 * The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 */
public class Leetcode962 {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        //存储第i个数字右边最大的数
        int[] rMax = new int[n];
        rMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], A[i]);
        }
        int left = 0, right = 0;
        int ans = 0;
        while (right < n) {
            while (left < right && A[left] > rMax[right]) {
                left++;
            }
            ans = Math.max(ans, right - left);
            right++;
        }
        return ans;
    }
}
