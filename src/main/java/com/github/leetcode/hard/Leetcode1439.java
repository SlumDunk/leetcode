package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given an m * n matrix, mat, and an integer k, which has its rows sorted in non-decreasing order.
 * <p>
 * You are allowed to choose exactly 1 element from each row to form an array. Return the Kth smallest array sum among all possible arrays.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,3,11],[2,4,6]], k = 5
 * Output: 7
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
 * Example 2:
 * <p>
 * Input: mat = [[1,3,11],[2,4,6]], k = 9
 * Output: 17
 * Example 3:
 * <p>
 * Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
 * Output: 9
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.
 * Example 4:
 * <p>
 * Input: mat = [[1,1,10],[2,2,9]], k = 7
 * Output: 12
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat.length[i]
 * 1 <= m, n <= 40
 * 1 <= k <= min(200, n ^ m)
 * 1 <= mat[i][j] <= 5000
 * mat[i] is a non decreasing array.
 */
public class Leetcode1439 {
    /**
     * mnklog(nk)
     * @param mat
     * @param k
     * @return
     */
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < mat[0].length && i < k; i++) {
            li.add(mat[0][i]);
        }

        for (int i = 1; i < mat.length; i++) {
            li = getKthSmallest(mat[i], li, k);
        }
        return li.get(k - 1);
    }

    private List<Integer> getKthSmallest(int[] arr, List<Integer> li, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < li.size(); j++) {
                pq.offer(arr[i] + li.get(j));
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int sum = pq.poll();
            res.add(sum);
        }
        return res;
    }
}
