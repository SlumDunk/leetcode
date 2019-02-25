package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 12:27
 * @Description: A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * <p>
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 * <p>
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 * <p>
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 */
public class Leetcode873 {
    /**
     * Save array A to a hash set s.
     * Start from base (A[i], A[j]) as the first two element in the sequence,
     * we try to find the Fibonacci like subsequence as long as possible,
     * <p>
     * Initial (a, b) = (A[i], A[j])
     * While the set s contains a + b, we update (a, b) = (b, a + b).
     * In the end we update the longest length we find.
     * <p>
     * Time Complexity:
     * O(N^2logM), where M is the max(A).
     *
     * @param A
     * @return
     */
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        } else {
            int len = A.length;
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < len; i++) {
                set.add(A[i]);
            }
            int res = 2;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int a = A[i], b = A[j], l = 2;
                    while (set.contains(a + b)) {
                        b = a + b;
                        a = b - a;
                        l++;
                    }
                    res = Math.max(res, l);
                }
            }
            return res > 2 ? res : 0;
        }
    }
}
