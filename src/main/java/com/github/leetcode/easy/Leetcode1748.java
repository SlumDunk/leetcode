package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 * <p>
 * Return the sum of all the unique elements of nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,2]
 * Output: 4
 * Explanation: The unique elements are [1,3], and the sum is 4.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1,1]
 * Output: 0
 * Explanation: There are no unique elements, and the sum is 0.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,4,5]
 * Output: 15
 * Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Leetcode1748 {
    public int sumOfUnique(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        Set<Integer> unUnique = new HashSet<>();
        int sum = 0;
        for (int num :
                nums) {
            if (unique.contains(num)) {
                unUnique.add(num);
            }
            unique.add(num);
        }

        for (int num :
                nums) {
            if (!unUnique.contains(num)) {
                sum += num;
            }
        }

        return sum;
    }
}
