package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 14:43
 * @Description: Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * <p>
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 * <p>
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] is 0 or 1
 */
public class Leetcode1004 {
    /**
     * 滑动窗口
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int i = 0;//窗口左边界
        int j = 0;//窗口右边界
        int max = 0;
        while (j < A.length) {
            if (A[j] == 0) K--;
            if (K >= 0) max = Math.max(j - i + 1, max);
            if (K < 0) {//调整窗口左边界
                while (A[i++] == 1) continue;
                K++;
            }
            j++;
        }
        return max;
    }
}
