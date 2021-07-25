package com.github.leetcode.medium;

/**
 * You are given an integer array nums. You can choose exactly one index (0-indexed) and remove the element. Notice that the index of the elements may change after the removal.
 * <p>
 * For example, if nums = [6,1,7,4,1]:
 * <p>
 * Choosing to remove index 1 results in nums = [6,7,4,1].
 * Choosing to remove index 2 results in nums = [6,1,4,1].
 * Choosing to remove index 4 results in nums = [6,1,7,4].
 * An array is fair if the sum of the odd-indexed values equals the sum of the even-indexed values.
 * <p>
 * Return the number of indices that you could choose such that after the removal, nums is fair.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,1,6,4]
 * Output: 1
 * Explanation:
 * Remove index 0: [1,6,4] -> Even sum: 1 + 4 = 5. Odd sum: 6. Not fair.
 * Remove index 1: [2,6,4] -> Even sum: 2 + 4 = 6. Odd sum: 6. Fair.
 * Remove index 2: [2,1,4] -> Even sum: 2 + 4 = 6. Odd sum: 1. Not fair.
 * Remove index 3: [2,1,6] -> Even sum: 2 + 6 = 8. Odd sum: 1. Not fair.
 * There is 1 index that you can remove to make nums fair.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 3
 * Explanation: You can remove any index and the remaining array is fair.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * Explanation: You cannot make a fair array after removing any index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class Leetcode1664 {
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int result = 0;
        int oddSum[] = new int[len];
        int evenSum[] = new int[len];
        oddSum[0] = 0;
        evenSum[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (i % 2 == 0) {
                oddSum[i] = oddSum[i - 1];
                evenSum[i] = evenSum[i - 1] + nums[i];
            } else {
                evenSum[i] = evenSum[i - 1];
                oddSum[i] = oddSum[i - 1] + nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            // 原来偶数位的会变成奇数位
            int evenS = (i > 0 ? evenSum[i - 1] : 0) + (oddSum[len - 1] - oddSum[i]);
            int oddS = (i > 0 ? oddSum[i - 1] : 0) + (evenSum[len - 1] - evenSum[i]);
            if (evenS == oddS) {
                result++;
            }
        }
        return result;
    }
}
