package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 15:36
 * @Description: Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 * Example 2:
 * <p>
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * Example 3:
 * <p>
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation:
 * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 */
public class Leetcode1060 {

    /**
     * O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int missingElement(int[] nums, int k) {
        //前一数字
        int prev = nums[0];
        int index = 1;
        while (k > 0) {
            if (index < nums.length) {
                if (nums[index] - prev != 1) {
                    k--;
                    prev++;
                } else {
                    prev = nums[index];
                    index++;
                }
            } else {//越界但还没有填充完
                prev += k;
                return prev;
            }
        }
        return prev;
    }

    /**
     * O(lgn)
     *
     * @param nums
     * @param k
     * @return
     */
    public int bsMissingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {//right=left+1
            int mid = left + (right - left) / 2;
            int numMiss = nums[mid] - nums[left] - (mid - left);
            if (numMiss >= k) {
                right = mid;
            } else {
                left = mid;
                k -= numMiss;
            }
        }
        // At this point we will reach a specific interval [nums[left], nums[right]]
        // it is very possible that the target we are looking for is beyond this interval
        // For example, [1,2] and we want k = 100
        if (nums[right] - nums[left] - 1 >= k) {
            return nums[left] + k;
        }
        return nums[right] + k - (nums[right] - nums[left] - 1);
    }
}
