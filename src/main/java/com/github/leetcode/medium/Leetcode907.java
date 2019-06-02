package com.github.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 22:32
 * @Description: Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 */
public class Leetcode907 {
    /**
     * for each element, find the number of subarrays whose min element is this element
     *
     * @param A
     * @return
     */
    public int sumSubarrayMins(int[] A) {
        //从左向右扫，存储小于当前值的下标
        Integer[] left = new Integer[A.length];
        Arrays.fill(left, -1);
        //从右往左扫，存储小于当前值的下标
        Integer[] right = new Integer[A.length];
        Arrays.fill(right, A.length);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int leftLen = i - left[i];
            int rightLen = right[i] - i;
            sum += A[i] * (leftLen * rightLen);
            sum %= 1e9 + 7;
        }
        return sum;
    }
}
