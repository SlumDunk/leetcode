package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * Given two arrays nums1 and nums2.
 * <p>
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
 * <p>
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * Output: 18
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 * Example 2:
 * <p>
 * Input: nums1 = [3,-2], nums2 = [2,-6,7]
 * Output: 21
 * Explanation: Take subsequence [3] from nums1 and subsequence [7] from nums2.
 * Their dot product is (3*7) = 21.
 * Example 3:
 * <p>
 * Input: nums1 = [-1,-1], nums2 = [1,1]
 * Output: -1
 * Explanation: Take subsequence [-1] from nums1 and subsequence [1] from nums2.
 * Their dot product is -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums1.length, nums2.length <= 500
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
public class Leetcode1458 {
    /**
     * https://www.youtube.com/watch?v=Hm9r41TwLFo&t=4s
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] copyNums1 = new int[m + 1];
        int[] copyNums2 = new int[n + 1];
        for (int i = 0; i < m; i++) {
            copyNums1[i + 1] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            copyNums2[i + 1] = nums2[i];
        }

        nums1 = copyNums1;
        nums2 = copyNums2;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }

        int ret = Integer.MIN_VALUE;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j], Math.max(0, dp[i - 1][j - 1]) + nums1[i] * nums2[j]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);

                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret;
    }
}
