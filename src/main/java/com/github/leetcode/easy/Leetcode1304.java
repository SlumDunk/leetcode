package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/2/20 19:29
 * @Description: Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public class Leetcode1304 {
    public int[] sumZero(int n) {
        int left = 0;
        int right = n - 1;
        int[] ans = new int[n];
        int i = 1;
        while (left <= right) {
            if (left == right) {
                ans[left] = 0;
            } else {
                ans[left] = i;
                ans[right] = -i;
                i += 1;
            }
            left += 1;
            right -= 1;
        }
        return ans;
    }
}
