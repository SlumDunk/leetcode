package com.github.leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 20:16
 * @Description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //先对数组进行排序
        Arrays.sort(nums);
        int len = nums.length;
        int max = 1;
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] == 1) {//相差1，符合情况
                count++;
            } else if (nums[i] == nums[i - 1]) {//相等情况，继续
                continue;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }
        //防止漏掉最后一个元素
        max = Math.max(count, max);
        return max;
    }

    public int longestConsecutive_(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int n = nums.length;
        int longest = 0;

        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            int down = cur - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = cur + 1;

            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            longest = Math.max(longest, up - down - 1);
        }

        return longest;

    }
}
