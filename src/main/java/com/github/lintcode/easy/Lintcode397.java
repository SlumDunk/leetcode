package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 7/25/19 11:34
 * @Description: Give an integer array，find the longest increasing continuous subsequence in this array.
 * <p>
 * An increasing continuous subsequence:
 * <p>
 * Can be from right to left or from left to right.
 * Indices of the integers in the subsequence should be continuous.
 * Example
 * Example 1:
 * <p>
 * Input: [5, 4, 2, 1, 3]
 * Output: 4
 * Explanation:
 * For [5, 4, 2, 1, 3], the LICS  is [5, 4, 2, 1], return 4.
 * Example 2:
 * <p>
 * Input: [5, 1, 2, 3, 4]
 * Output: 4
 * Explanation:
 * For [5, 1, 2, 3, 4], the LICS  is [1, 2, 3, 4], return 4.
 * Challenge
 * O(n) time and O(1) extra space.
 */
public class Lintcode397 {
    int result = 0;

    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        int n = A.length;
        if (n == 0) {
            return 0;
        } else {
            calc(A, n);
            //inverse A
            int i, j, t;
            i = 0;
            j = n - 1;
            while (i < j) {
                t = A[i];
                A[i] = A[j];
                A[j] = t;
                i++;
                j--;
            }
            calc(A, n);
            return result;
        }
    }

    void calc(int[] A, int n) {
        int[] f = new int[2];
        int i;
        for (i = 0; i < n; i++) {
            f[i % 2] = 1;
            if (i > 0 && A[i] > A[i - 1]) {
                f[i % 2] = f[(i - 1) % 2] + 1;
            }
            result = Math.max(result, f[i % 2]);
        }
    }
}
