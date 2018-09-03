package com.github.leetcode.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.tools.tree.BooleanExpression;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 22:11
 * @Description: An array is monotonic if it is either monotone increasing or monotone decreasing.
 * <p>
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * <p>
 * Return true if and only if the given array A is monotonic.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 * <p>
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 * <p>
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 * <p>
 * Input: [1,1,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class Leetcode896 {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 1) {
            return Boolean.TRUE;
        }
        int count = 0;
        int len = A.length;
        Boolean isAsc = Boolean.TRUE;
        for (int i = 0; i < len - 1; i++) {
            if (A[i] > A[i + 1]) {
                isAsc = Boolean.FALSE;
            }
        }

        if (isAsc) {
            return Boolean.TRUE;
        } else {
            for (int i = 0; i < len - 1; i++) {
                if (A[i] < A[i + 1]) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }


    }
}
