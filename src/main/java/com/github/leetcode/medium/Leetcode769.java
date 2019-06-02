package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/29/19 22:20
 * @Description: Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 * <p>
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note:
 * <p>
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
public class Leetcode769 {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int m = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                count++;
            }
        }
        return count;
    }
}
