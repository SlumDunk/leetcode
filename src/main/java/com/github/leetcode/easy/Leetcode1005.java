package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/2/19 12:11
 * @Description: Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 * <p>
 * Return the largest possible sum of the array after modifying it in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 * <p>
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 * <p>
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 */
public class Leetcode1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        if (A[0] >= 0 && K % 2 != 0) {//都为正， K不为偶数
            A[0] = -A[0];
        } else if (A[0] < 0) { //&& K % 2 == 0) {
            int change = 0;
            while (K > 0 && A[change] < 0 && change < A.length) {
                A[change] = -A[change++];
                K--;
            }
            if (K % 2 != 0) {//K不为偶数
                int index = A[change] < A[change - 1] ? change : change - 1;
                A[index] = -A[index];
            }
        }
        for (int val : A) sum += val;
        return sum;
    }
}
