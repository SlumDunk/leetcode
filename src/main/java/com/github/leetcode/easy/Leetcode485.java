package com.github.leetcode.easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 * @author liuzhongda
 */
public class Leetcode485 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int max = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                count++;
            } else {//变号的时候重置计数器，并比较max
                max = Math.max(max, count);
                count = 0;
            }
        }
        //以1结尾的情况
        max = Math.max(max, count);
        return max;
    }
}
