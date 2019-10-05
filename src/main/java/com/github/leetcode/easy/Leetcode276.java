package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 15:21
 * @Description: There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * <p>
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note:
 * n and k are non-negative integers.
 * <p>
 * Example:
 * <p>
 * Input: n = 3, k = 2
 * Output: 6
 * Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
 * <p>
 * post1  post2  post3
 * -----      -----  -----  -----
 * 1         c1     c1     c2
 * 2         c1     c2     c1
 * 3         c1     c2     c2
 * 4         c2     c1     c1
 * 5         c2     c1     c2
 * 6         c2     c2     c1
 */
public class Leetcode276 {
    /**
     * dp[i]=(k-1)×(dp[i-1]+dp[i-2])
     * dp[i-1]×(k-1)代表当前格子的颜色和前一个不同的方案
     * dp[i-2]×(k-1)代表当前格子的颜色和前一个相同的方案
     *
     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        //i,i-1,i-2
        //跟前一位不同+跟前一位相同
        //dp[n]=dp[n-1]*(k-1)+dp[n-2]*(k-1)
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }
}
