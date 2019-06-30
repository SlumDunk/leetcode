package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 08:31
 * @Description: Given an array A, partition it into two (contiguous) subarrays left and right so that:
 * <p>
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * Example 2:
 * <p>
 * Input: [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * It is guaranteed there is at least one way to partition A as described.
 */
public class Leetcode915 {
    public int partitionDisjoint(int[] A) {
        //全局最大值
        int globalMax = A[0];
        //左半部分最大值
        int leftMax = A[0];
        //边界位置
        int boundary = 0;

        for (int i = 0; i < A.length; i++) {
            globalMax = A[i] > globalMax ? A[i] : globalMax;
            //当前值归入左边范围
            if (A[i] < leftMax) {
                boundary = i;
                leftMax = globalMax > leftMax ? globalMax : leftMax;
            }
        }
        return boundary + 1;
    }
}
