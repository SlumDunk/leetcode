package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 14:01
 * @Description: Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.
 * <p>
 * If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.
 * <p>
 * Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,10,9,8]
 * Output: [10,9]
 * Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements.
 * Example 2:
 * <p>
 * Input: nums = [4,4,7,6,7]
 * Output: [7,7,6]
 * Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
 * Example 3:
 * <p>
 * Input: nums = [6]
 * Output: [6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 100
 */
public class Leetcode1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            totalSum += num;
        }
        int checkFrom = nums.length - 1;
        int tempSum = 0;
        while (checkFrom >= 0) {
            if (tempSum <= (totalSum - tempSum)) {
                tempSum += nums[checkFrom];
                result.add(nums[checkFrom]);
            }
            checkFrom--;
        }
        return result;
    }
}
