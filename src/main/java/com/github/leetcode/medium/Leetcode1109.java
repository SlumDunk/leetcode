package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/22/19 13:19
 * @Description:
 */
public class Leetcode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int len = bookings.length;
        int[] ans = new int[n];
        for (int i = 0; i < len; i++) {
            int[] a = bookings[i];
            ans[a[0] - 1] += a[2];
            if (a[1] < n) ans[a[1]] -= a[2];
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
