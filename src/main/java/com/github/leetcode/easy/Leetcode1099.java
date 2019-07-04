package com.github.leetcode.easy;

import java.util.TreeSet;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 22:54
 * @Description: Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * Example 2:
 * <p>
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i] <= 1000
 * 1 <= K <= 2000
 */
public class Leetcode1099 {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int a : A) {
            Integer pre = set.lower(K - a);
            if (pre != null) {
                res = Math.max(res, a + pre);
            }
            set.add(a);
        }
        return res;
    }
}
