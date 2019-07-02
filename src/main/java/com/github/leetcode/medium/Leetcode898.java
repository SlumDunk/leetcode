package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 17:01
 * @Description:We have an array A of non-negative integers.
 * <p>
 * For every (contiguous) subarray B = [A[i], A[i+1], ..., A[j]] (with i <= j), we take the bitwise OR of all the elements in B, obtaining a result A[i] | A[i+1] | ... | A[j].
 * <p>
 * Return the number of possible results.  (Results that occur more than once are only counted once in the final answer.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [0]
 * Output: 1
 * Explanation:
 * There is only one possible result: 0.
 * Example 2:
 * <p>
 * Input: [1,1,2]
 * Output: 3
 * Explanation:
 * The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
 * These yield the results 1, 1, 2, 1, 3, 3.
 * There are 3 unique values, so the answer is 3.
 * Example 3:
 * <p>
 * Input: [1,2,4]
 * Output: 6
 * Explanation:
 * The possible results are 1, 2, 3, 4, 6, and 7.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 10^9
 */
public class Leetcode898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), pre = new HashSet<>();
        for (int i : A) {
            Set<Integer> cur = new HashSet<>();
            cur.add(i);
            for (int j : pre) // pre: A[0] | ... | A[i - 1], A[1] | ... | A[i - 1], A[2] | ... | A[i - 1], ..., A[i - 1]
                cur.add(i | j); // cur: A[0] | ... | A[i - 1] | A[i], A[1] | ... | A[i - 1] | A[i], ..., A[i - 1] | A[i], A[i]
            res.addAll(pre = cur);
        }
        return res.size();
    }
}
