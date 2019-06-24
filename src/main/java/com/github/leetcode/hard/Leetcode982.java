package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 12:59
 * @Description: Given an array of integers A, find the number of triples of indices (i, j, k) such that:
 * <p>
 * 0 <= i < A.length
 * 0 <= j < A.length
 * 0 <= k < A.length
 * A[i] & A[j] & A[k] == 0, where & represents the bitwise-AND operator.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,3]
 * Output: 12
 * Explanation: We could choose the following i, j, k triples:
 * (i=0, j=0, k=1) : 2 & 2 & 1
 * (i=0, j=1, k=0) : 2 & 1 & 2
 * (i=0, j=1, k=1) : 2 & 1 & 1
 * (i=0, j=1, k=2) : 2 & 1 & 3
 * (i=0, j=2, k=1) : 2 & 3 & 1
 * (i=1, j=0, k=0) : 1 & 2 & 2
 * (i=1, j=0, k=1) : 1 & 2 & 1
 * (i=1, j=0, k=2) : 1 & 2 & 3
 * (i=1, j=1, k=0) : 1 & 1 & 2
 * (i=1, j=2, k=0) : 1 & 3 & 2
 * (i=2, j=0, k=1) : 3 & 2 & 1
 * (i=2, j=1, k=0) : 3 & 1 & 2
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000
 * 0 <= A[i] < 2^16
 */
public class Leetcode982 {
    public int countTriplets(int[] A) {
        int N = 1 << 16, M = 4;
        int[][] dp = new int[M][N];

        dp[0][N - 1] = 1;
        //0, 1, 2
        for (int i = 0; i < M - 1; i++) {
            //遍历16个位
            for (int j = 0; j < N; j++) {
                //遍历数组中所有元素
                for (int a : A) {
                    dp[i + 1][j & a] += dp[i][j];
                }
            }
        }
        //3个数目标值为0
        return dp[M - 1][0];
    }

    public int _3Sum(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : A) {
            for (int b : A) {
                int v = a & b;
                count.put(v, count.getOrDefault(v, 0) + 1);
            }
        }

        int res = 0;
        for (int a : A) {
            for (int e : count.keySet()) {
                if ((a & e) == 0) res += count.get(e);
            }
        }
        return res;
    }
}
