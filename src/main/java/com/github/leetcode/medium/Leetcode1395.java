package com.github.leetcode.medium;

/**
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * <p>
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * <p>
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: rating = [2,5,3,4,1]
 * Output: 3
 * Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
 * Example 2:
 * <p>
 * Input: rating = [2,1,3]
 * Output: 0
 * Explanation: We can't form any team given the conditions.
 * Example 3:
 * <p>
 * Input: rating = [1,2,3,4]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == rating.length
 * 3 <= n <= 1000
 * 1 <= rating[i] <= 105
 * All the integers in rating are unique.
 */
public class Leetcode1395 {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0; // 左边比它小的
            int r = 0; // 右边比它大的
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) l++;
            }

            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) r++;
            }
            ans += (l * r); // 递增
            ans += (i - l) * (n - 1 - i - r); // 递减
        }
        return ans;
    }
}
