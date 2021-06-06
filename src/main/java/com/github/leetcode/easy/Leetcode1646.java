package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 16:36
 * @Description: You are given an integer n. An array nums of length n + 1 is generated in the following way:
 * <p>
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] when 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
 * Return the maximum integer in the array nums​​​.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 7
 * Output: 3
 * Explanation: According to the given rules:
 * nums[0] = 0
 * nums[1] = 1
 * nums[(1 * 2) = 2] = nums[1] = 1
 * nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
 * nums[(2 * 2) = 4] = nums[2] = 1
 * nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
 * nums[(3 * 2) = 6] = nums[3] = 2
 * nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
 * Hence, nums = [0,1,1,2,1,3,2,3], and the maximum is 3.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: According to the given rules, the maximum between nums[0], nums[1], and nums[2] is 1.
 * Example 3:
 * <p>
 * Input: n = 3
 * Output: 2
 * Explanation: According to the given rules, the maximum between nums[0], nums[1], nums[2], and nums[3] is 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 100
 */
public class Leetcode1646 {
    public int getMaximumGenerated(int n) {
        int f[] = new int[n + 1];
        f[0] = 0;
        int max_num = 0;
        if (n >= 1) {
            f[1] = 1;
            max_num = 1;
            int i = 1;
            while (2 * i <= n) {
                if (2 * i <= n) {
                    f[2 * i] = f[i];
                    max_num = Math.max(max_num, f[2 * i]);
                }
                if (((2 * i) + 1) <= n) {
                    f[(2 * i) + 1] = f[i] + f[i + 1];
                    max_num = Math.max(max_num, f[(2 * i) + 1]);
                }
                i++;
            }
        }
        return max_num;
    }
}
