package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 20:09
 * @Description: Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * <p>
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 * After flipping, the maximum number of consecutive 1s is 4.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */
public class Leetcode487 {
    /**
     * 1 0 1 1 0
     * -1 -1 1
     * <p>
     * -1 1 4
     * <p>
     * 1 4
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int prevZero = -1;
        int currentZero = -1;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {//找到新的0
                max = Math.max(max, i - prevZero - 1);// prevZero变成1

                prevZero = currentZero;
                currentZero = i;
            }
        }

        max = Math.max(max, nums.length - prevZero - 1);

        return max;
    }
}
