package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/12/19 23:40
 * @Description: A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequences:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A subsequence slice of that array is any sequence of integers (P0, P1, ..., Pk) such that 0 ≤ P0 < P1 < ... < Pk < N.
 * <p>
 * A subsequence slice (P0, P1, ..., Pk) of array A is called arithmetic if the sequence A[P0], A[P1], ..., A[Pk-1], A[Pk] is arithmetic. In particular, this means that k ≥ 2.
 * <p>
 * The function should return the number of arithmetic subsequence slices in the array A.
 * <p>
 * The input contains N integers. Every integer is in the range of -231 and 231-1 and 0 ≤ N ≤ 1000. The output is guaranteed to be less than 231-1.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2, 4, 6, 8, 10]
 * <p>
 * Output: 7
 * <p>
 * Explanation:
 * All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 */
public class Leetcode446 {
    public static void main(String[] args) {
        Leetcode446 leetcode446 = new Leetcode446();
        leetcode446.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});
    }

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int ans = 0;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey((long) A[i])) {
                map.put((long) A[i], new ArrayList<>());
            }
            map.get((long) A[i]).add(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //中间的数*2=左右数的和
                long target = 2 * (long) A[j] - A[i];
                if (map.containsKey(target)) {
                    for (int k : map.get(target)) {
                        if (k < j) {
                            dp[i][j] += (dp[j][k] + 1);
                        }
                    }
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
