package com.github.leetcode.medium;

import com.github.leetcode.vo.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/7/19 13:16
 * @Description: Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length < 1000
 * 0 <= B.length < 1000
 * 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Leetcode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[][]{};
        }
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);
            if (endMin >= startMax) {
                res.add(new int[]{startMax, endMin});
            }
            if (A[i][1] == endMin) {
                i++;
            }

            if (B[j][1] == endMin) {
                j++;
            }
        }

        int[][] ans = new int[res.size()][2];
        int index = 0;
        for (int[] item :
                res) {
            ans[index] = item;
            index++;
        }
        return ans;
    }


    /**
     * O(m+n)
     *
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection_(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[][]{};
        }
        int m = A.length, n = B.length;
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < m && j < n) {
            int startMax = Math.max(A[i][0], B[j][0]);
            int endMin = Math.min(A[i][1], B[j][1]);

            if (endMin >= startMax) {
                res.add(new int[]{startMax, endMin});
            }

            if (A[i][1] == endMin) {
                i++;
            }

            if (B[j][1] == endMin) {
                j++;
            }
        }

        int[][] ans = new int[res.size()][2];
        int index = 0;
        for (int[] item : res) {
            ans[index] = item;
            index++;
        }
        return ans;
    }
}
