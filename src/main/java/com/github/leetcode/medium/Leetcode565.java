package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 14:01
 * @Description: A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
 * <p>
 * Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
 * <p>
 * Example 1:
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * Note:
 * N is an integer within the range [1, 20,000].
 * The elements of A are all distinct.
 * Each element of A is an integer within the range [0, N-1].
 */
public class Leetcode565 {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else {
            int max = 0;
            Set<Integer> indexSet = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int tmp = 0;
                if (!indexSet.contains(i)) {
                    max = Math.max(max, findLength(i, nums, indexSet));
                }

            }
            return max;
        }
    }

    private int findLength(int index, int[] nums, Set<Integer> indexSet) {
        if (indexSet.contains(index)) {
            return 0;
        } else {
            indexSet.add(index);
            return 1 + findLength(nums[index], nums, indexSet);
        }
    }
}
