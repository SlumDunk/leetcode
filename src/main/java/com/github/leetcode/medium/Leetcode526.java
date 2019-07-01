package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 09:07
 * @Description: Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 * <p>
 * The number at the ith position is divisible by i.
 * i is divisible by the number at the ith position.
 * <p>
 * <p>
 * Now given N, how many beautiful arrangements can you construct?
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation:
 * <p>
 * The first beautiful arrangement is [1, 2]:
 * <p>
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 * <p>
 * The second beautiful arrangement is [2, 1]:
 * <p>
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 * <p>
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 * <p>
 * <p>
 * Note:
 * <p>
 * N is a positive integer and will not exceed 15.
 */
public class Leetcode526 {
    private int answer;
    private int[] nums;

    public int countArrangement(int N) {
        this.answer = 0;
        this.nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = i;
        }

        backtrack(1);
        return answer;
    }

    /**
     * 前i个数字已经满足条件
     * @param i
     */
    private void backtrack(int i) {
        if (i == nums.length) {
            answer++;
            return;
        }

        for (int j = i; j < nums.length; j++) {
            // i和j能配对
            if ((nums[j] % i == 0) || (i % nums[j] == 0)) {
                swap(nums, i, j);
                backtrack(i + 1);
                swap(nums, i, j);
            }
        }
    }

    /**
     * 交换位置
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
