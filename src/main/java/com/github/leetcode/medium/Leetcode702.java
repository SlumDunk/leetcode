package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 08:20
 * @Description: Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
 * <p>
 * You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: array = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * <p>
 * Input: array = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * Note:
 * <p>
 * You may assume that all elements in the array are unique.
 * The value of each element in the array will be in the range [-9999, 9999].
 */
public class Leetcode702 {
    interface ArrayReader {
        Integer get(int k);
    }

    /**
     * -1 0 3 5 9 12
     *        5 9 12
     * @param reader
     * @param target
     * @return
     */
    public int search(ArrayReader reader, int target) {
        int heigh = 2;
        int low = 0;
        while (low < heigh) {
            if (reader.get(heigh) == target || reader.get(low) == target)
                return reader.get(heigh) == target ? heigh : low;
            if (reader.get(heigh) < target) {
                low = heigh + 1;
                heigh = heigh * 2 > 10000 ? 10000 : heigh * 2;
            } else {
                heigh = low + (heigh - low) / 2;
            }
        }
        return -1;
    }
}
