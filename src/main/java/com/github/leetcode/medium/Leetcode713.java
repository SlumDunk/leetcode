package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 12/3/18 21:52
 * @Description: Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 * max-product-window
 */
public class Leetcode713 {
    public static void main(String[] args) {
        Leetcode713 leetcode713 = new Leetcode713();
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(leetcode713.numSubarrayProductLessThanK(nums, k));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int cnt = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro *= nums[j];
            while (i <= j && pro >= k) {
                pro /= nums[i++];
            }
            cnt += j - i + 1;
        }
        return cnt;
    }

    private int numSubarrayProduct(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        } else {
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                result += dfs(nums, k, 1, i);
            }
            return result;
        }
    }

    private int dfs(int[] nums, int k, int preProduct, int startIndex) {
        int result = 0;
        if (startIndex < nums.length) {
            if (preProduct * nums[startIndex] < k) {
                result++;
                result += dfs(nums, k, preProduct * nums[startIndex], startIndex + 1);
            }
        }
        return result;
    }
}
