package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 16:55
 * @Description: Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.
 * <p>
 * In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].
 * <p>
 * If there is no way to make arr1 strictly increasing, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
 * Output: 1
 * Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].
 * Example 2:
 * <p>
 * Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
 * Output: 2
 * Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].
 * Example 3:
 * <p>
 * Input: arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
 * Output: -1
 * Explanation: You can't make arr1 strictly increasing.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr1.length, arr2.length <= 2000
 * 0 <= arr1[i], arr2[i] <= 10^9
 */
public class Leetcode1187 {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int inF = 1_000_000_000;
        int n = arr1.length;
        if (n == 1) return 0;
        //保持a[i]的情况下使得0.....i严格递增的最小成本
        int[] keep = new int[n];
        Arrays.fill(keep, inF);
        keep[0] = 0;
        Arrays.sort(arr2);
        //arr2中的元素严格递增
        List<Integer> list = new ArrayList();
        list.add(arr2[0]);
        for (int i = 1; i < arr2.length; i++) {
            if (arr2[i] > list.get(list.size() - 1)) list.add(arr2[i]);
        }
        int m = list.size();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) b[i] = list.get(i);
        //前n个元素严格单调递增 且a[i]=b[j]的最小成本
        int dp[][] = new int[n][m];
        //第1个元素变成b[j]的成本都是1
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) Arrays.fill(dp[i], inF);
        //循环n
        for (int i = 1; i < n; i++) {
            int minKeep = inF, minSwap = inF;
            //循环m
            for (int j = 0; j < m; j++) {
                //case4 b[k] < b[j]
                if (j > 0) minSwap = Math.min(minSwap, dp[i - 1][j - 1] + 1);
                //case3 a[i] > b[j]
                if (arr1[i] > b[j]) minKeep = Math.min(minKeep, dp[i - 1][j]);
                //case1 a[i] > a[i-1]
                if (arr1[i] > arr1[i - 1]) keep[i] = keep[i - 1];
                //case2 b[j] > a[i-1]
                if (b[j] > arr1[i - 1]) dp[i][j] = 1 + keep[i - 1];
                keep[i] = Math.min(keep[i], minKeep);
                dp[i][j] = Math.min(dp[i][j], minSwap);
            }
        }
        int ans = Math.min(keep[n - 1], dp[n - 1][m - 1]);
        return ans == inF ? -1 : ans;
    }
}
