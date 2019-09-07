package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 12:44
 * @Description: Given two arrays of integers with equal lengths, return the maximum value of:
 * <p>
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * <p>
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * Output: 13
 * Example 2:
 * <p>
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 */
public class Leetcode1131 {

    /**
     * i>j & arr1[i]>arr1[j] & arr2[i]>arr2[j]
     * (1) arr1[i]+arr2[i]+i - (arr1[j] + arr2[j] + j)
     * <p>
     * i>j & arr1[i]>arr1[j] & arr2[i]<arr2[j]
     * (2) arr1[i]-arr2[i]+i - (arr1[j]-arr2[j]+j)
     * <p>
     * i>j & arr1[i]>arr1[j] & arr2[i]>arr2[j]
     * (3)-arr1[i]-arr2[i]+i -(-arr1[j]-arr2[j]+j)
     * <p>
     * i>j & arr1[i]<arr1[j] & arr2[i]>arr2[j]
     * (4)-arr1[i]+arr2[i]+i-(-arr1[j]+arr2[j]+j)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0;

        int min1 = arr1[0] + arr2[0];
        int min2 = -arr1[0] + arr2[0];
        int min3 = arr1[0] - arr2[0];
        int min4 = -arr1[0] - arr2[0];

        for (int i = 1; i < arr1.length; i++) {
            int cur1 = arr1[i] + arr2[i] + i;
            int cur2 = -arr1[i] + arr2[i] + i;
            int cur3 = arr1[i] - arr2[i] + i;
            int cur4 = -arr1[i] - arr2[i] + i;
            res = Math.max(res, cur1 - min1);
            res = Math.max(res, cur2 - min2);
            res = Math.max(res, cur3 - min3);
            res = Math.max(res, cur4 - min4);
            min1 = Math.min(cur1, min1);
            min2 = Math.min(cur2, min2);
            min3 = Math.min(cur3, min3);
            min4 = Math.min(cur4, min4);
        }

        return res;
    }
}
