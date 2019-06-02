package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 21:34
 * @Description: Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * <p>
 * Return the least number of moves to make every value in A unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 * Example 2:
 * <p>
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class Leetcode945 {
    public int minIncrementForUnique(int[] A) {
        int count = 0;
        if (A.length == 0) return 0;
        Arrays.sort(A);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                queue.add(A[i]);
            } else {
                int k = A[i - 1] + 1;
                while (k < A[i]) {
                    if (!queue.isEmpty()) {
                        count += k - queue.poll();
                    } else {
                        break;
                    }
                    k++;
                }
            }
        }
        int k = A[A.length - 1] + 1;
        while (!queue.isEmpty()) {
            count += k - queue.poll();
            k++;
        }
        return count;
    }
}
