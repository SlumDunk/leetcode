package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 16:11
 * @Description: Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.
 * <p>
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.
 * <p>
 * Return the maximum score of a pair of sightseeing spots.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class Leetcode1014 {

    /**
     * 8,1,5,2,6
     * 0 7 8 11 11 11
     * 0 8 7 6 5 6
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        //0 位置-1得加回来
        int res = 0, localMax = 1;
        for (int i = 0; i < A.length; i++) {
            res = Math.max(localMax + A[i] - 1, res);
            localMax = Math.max(localMax - 1, A[i]);
        }
        return res;
    }
}
