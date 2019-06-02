package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 14:55
 * @Description: Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Note: The length of given array won't exceed 10000.
 */
public class Leetcode503 {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int twoLength = 2 * length;
        int[] index = new int[twoLength];
        for (int i = length; i < twoLength; i++) {
            index[i] = i - length;
        }
        int current = length;
        for (int i = length - 1; i >= 0; i--) {
            while (current < twoLength && nums[index[current]] <= nums[i]) {
                current++;
            }
            if (current == twoLength) {
                result[i] = -1;
            } else {
                result[i] = nums[index[current]];
            }
            current--;
            index[current] = i;
        }
        return result;

    }
}
