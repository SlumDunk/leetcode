package com.github.leetcode.medium;

/**
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
 * <p>
 * Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * <p>
 * It is guaranteed that there will be an answer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,5,9], threshold = 6
 * Output: 5
 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
 * If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
 * Example 2:
 * <p>
 * Input: nums = [44,22,33,11,1], threshold = 5
 * Output: 44
 * Example 3:
 * <p>
 * Input: nums = [21212,10101,12121], threshold = 1000000
 * Output: 1
 * Example 4:
 * <p>
 * Input: nums = [2,3,5,7,11], threshold = 11
 * Output: 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 1 <= nums[i] <= 106
 * nums.length <= threshold <= 106
 */
public class Leetcode1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = Integer.MAX_VALUE;
        int low = 1, high = 0;
        for (int num :
                nums) {
            high = Math.max(high, num);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sumOfDivisions = getSumOfDivisions(nums, mid);
            if (sumOfDivisions > threshold) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    private int getSumOfDivisions(int[] nums, int division) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int div = nums[i] / division;
            if (nums[i] > div * division) div++;
            sum += div;
        }
        return sum;
    }
}
