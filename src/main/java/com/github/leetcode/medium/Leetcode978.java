package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/27/19 09:00
 * @Description: A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 * <p>
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 * <p>
 * Return the length of a maximum size turbulent subarray of A.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * Example 2:
 * <p>
 * Input: [4,8,12,16]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [100]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class Leetcode978 {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length;
        if (n == 1) {
            return 1;
        }
        //if array length is 2, result depends on whether those two elements are equal
        if (n == 2) {
            return A[1] == A[0] ? 1 : 2;
        }
        //当前波浪序列的长度
        int len = 2;
        int res = 1;
        for (int i = 1; i < n - 1; i++) {
            //能够组成波浪序列
            if (A[i - 1] < A[i] && A[i] > A[i + 1] || A[i - 1] > A[i] && A[i] < A[i + 1]) {
                len++;
                res = Math.max(res, len);
            } else {
                // 重新置位
                len = 2;
                //this condition checks if that  A[] have same values from begin to end,
                // if so, the result value remains 1 unchanged, if not, the result value is at least 2
                if (A[i - 1] != A[i] || A[i] != A[i + 1]) {
                    res = Math.max(res, 2);
                }
            }
        }
        return res;
    }
}
